package com.huangpeng.cloud.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2018-02-02 下午3:40
 * 类名: HttpClientUtil
 * </pre>
 **/

public class HttpClientUtil {
    private static Integer timeout = 20000;

    public static String origHttpPost(String url, String suffix, String method,Map<String, String> params) throws Exception {
        String result = "";
        if (StringHelper.isNullOrEmpty(url)) {
            throw new Exception("未配置URL连接");
        }
        // 拼接地址和方法
        url = url + (url.endsWith("/") ? suffix.substring(1) : suffix);
        if (method != null && !method.equals("")) {
            url = url + "?op=" + method;
        }
        // 处理访问参数
        if (params != null) {
            Iterator<Map.Entry<String, String>> iter = params.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                url = url + "&" + entry.getKey() + "=" + entry.getValue();
            }
        }
        CloseableHttpClient httpClient = null;
        try {
            // 协议兼容
            if (url.toLowerCase().indexOf("https://") > -1) {
//                httpClient = createCommonHttpsClient();
            } else if (url.toLowerCase().indexOf("http://") > -1) {
                httpClient = createHttpClient(url, timeout);
            } else {// 缺省使用http
                url = "http://" + url;
                httpClient = createHttpClient(url, timeout);
            }
            System.out.println("请求url:" + url);
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Access-Control-Allow-Origin", "*");
            httpPost.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
            List<NameValuePair> nvpsd = new ArrayList<NameValuePair>();
            if (params != null) {
                for (String key : params.keySet()) {
                    nvpsd.add(new BasicNameValuePair(key, params.get(key)));
                }
            }
            // 键值对没有拼接
            httpPost.setEntity(new UrlEncodedFormEntity(nvpsd, Consts.UTF_8));
            RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
            requestConfigBuilder.setConnectionRequestTimeout(timeout)
                    .setSocketTimeout(timeout).setConnectTimeout(timeout);
            httpPost.setConfig(requestConfigBuilder.build());
            CloseableHttpResponse response2 = httpClient.execute(httpPost);
            response2.addHeader("Access-Control-Allow-Methods",
                    "POST, GET, OPTIONS");
            response2.addHeader("Access-Control-Allow-Headers",
                    "Content-Type, Authorization, Accept,X-Requested-With");
            try {
                HttpEntity entity2 = response2.getEntity();
                if (response2.getStatusLine().getStatusCode() == 200) {
                    result = inputStreamToString(entity2.getContent());
                    System.out.println(result);
                } else {
                    result = inputStreamToString(response2.getEntity()
                            .getContent());
                    System.out.println(result);
                }
            } catch (IOException e) {
                System.out.println("返回编码" + response2.getStatusLine().getStatusCode());
                System.out.println(e);
            } finally {
                try {
                    response2.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return result;
    }

    private static CloseableHttpClient createHttpClient(String url, Integer timeOut) throws Exception {
        CloseableHttpClient httpClient = null;
        return createHttpClient(httpClient, timeOut);
    }

    private static CloseableHttpClient createHttpClient(CloseableHttpClient httpClient, Integer timeOut)
            throws Exception {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //设置socket.buffer为20K
        ConnectionConfig.Builder connConfigBuilder = ConnectionConfig.custom();
        connConfigBuilder.setBufferSize(20 * 1024);
        httpClientBuilder.setDefaultConnectionConfig(connConfigBuilder.build());
        //设置SoTimeout
        SocketConfig.Builder socketConfigBuilder = SocketConfig.custom();
        socketConfigBuilder.setSoTimeout(timeOut);
        httpClientBuilder.setDefaultSocketConfig(socketConfigBuilder.build());
        httpClient = httpClientBuilder.build();
        return httpClient;
    }

    public static String inputStreamToString(InputStream in) {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }
        String content = sb.toString();
        return content;
    }

}
