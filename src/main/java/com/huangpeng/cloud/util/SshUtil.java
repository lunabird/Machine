package com.huangpeng.cloud.util;

/**
 * <pre>
 * 任务：
 * 描述：ssh远程连接linux服务器
 * 作者：@author huangpeng
 * 时间：@create 2018-01-16 上午10:04
 * 类名: SshUtil
 * </pre>
 **/

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class SshUtil {
    public static String exec(String host, String user, String psw, int port, String command) throws JSchException {
        String result = "";
        Session session = null;
        ChannelExec openChannel = null;
        try {
            JSch jsch = new JSch();
            // getSession()只是创建一个session，需要设置必要的认证信息之后，调用connect()才能建立连接。
            session = jsch.getSession(user, host, port);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(psw);

            session.connect();
            openChannel = (ChannelExec) session.openChannel("exec");
            openChannel.setCommand(command);
            openChannel.setPty(true);
            int exitStatus = openChannel.getExitStatus();
            openChannel.connect();

            InputStream in = openChannel.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
            String buf = null;
            StringBuffer sb = new StringBuffer();
            while ((buf = reader.readLine()) != null) {
                sb.append(buf);
                System.out.println(buf);// 打印控制台输出
                result = result+buf+",";
            }
            if(result.endsWith(",")){
                result = result.substring(0,result.length()-1);
            }
        } catch (JSchException e) {
            result += e.getMessage();
//            e.printStackTrace();
            System.out.println(e);
            throw e;
        } catch (IOException e) {
            result += e.getMessage();
        } finally {
            if (openChannel != null && !openChannel.isClosed()) {
                openChannel.disconnect();
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
        return result;
    }

//    public static void main(String[] args){
//
//        String ip="118.190.21.49";
//        String port="15432";
//        String passwd="huangpeng123";
//        String os="linux";
//        String user="root";
//        String command="getAllUser";
//        String sudoer="huangpeng";
//        String shellCommand = "ls /home";
//        if(!sudoer.equalsIgnoreCase("root")){
//            shellCommand = "sudo " + shellCommand;
//        }
//        String usersList = "";
//        try {
//            usersList = SshUtil.exec(ip, sudoer, passwd, Integer.parseInt(port), shellCommand);
//        } catch (JSchException e) {
//            usersList = e.getMessage();
//        }
//        System.out.println(usersList);
//    }
}
