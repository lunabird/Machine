package com.huangpeng.cloud.passwordDetect.service;

import com.huangpeng.cloud.util.HttpClientUtil;
import com.huangpeng.cloud.util.MD5Pass;
import com.huangpeng.cloud.util.SshUtil;
import com.jcraft.jsch.JSchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2018-01-19 上午10:35
 * 类名: PasswordDetectService
 * </pre>
 **/
@Service
public class PasswordDetectService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 在windows主机上执行cmd命令
     * @param cmd
     * @return
     */
    public String  executeCmd(String cmd){
        Charset systemEncode = Charset.defaultCharset();//System.getProperty("file.encoding");
        Runtime r = Runtime.getRuntime();
        Process p = null;
        String cmdResult = "",result = "";
        BufferedReader br = null;
        InputStreamReader inputStreamReader = null;
        try {
            p = r.exec(cmd);
            inputStreamReader = new InputStreamReader(p.getInputStream(),Charset.forName("GBK"));
            br = new BufferedReader(inputStreamReader);

            String inline;
            int count = 1;
            while ((inline = br.readLine()) != null) {
                inline = "[" + count++ + "]" + inline.trim().replace("\n", "");
                cmdResult += inline;
                logger.info(inline);
            }
            p.destroy();
            p=null;
            logger.info("windows cmd result:"+cmdResult);
            System.out.println("cmdResult---"+cmdResult);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return cmdResult;
    }

//    public String sendHttpRequest() {
//        String url = "localhost:8080/0090hello";
//        String content = null;
//        try {
//            content = HttpClientUtil.origHttpPost(url,"","",null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            content = e.getMessage();
//            return content;
//        }
//        return content;
//    }

    public String linuxRequest(String ip,String port,String passwd,String user,String command,String sudoer)  {
        String result = "";
        String shellCommand = "";
        if(command.equalsIgnoreCase("getAllUser")){
            shellCommand = "sudo cat /etc/passwd | grep -e /home -e root:/root:/bin/bash | awk -F ':' '{print $1}'";
        }else if(command.equalsIgnoreCase("getPasswdModifyTime")){
            shellCommand = "grep \"" + user + ":\" /etc/shadow | awk -F \":\" '{print $3}' ";
        }else if(command.equalsIgnoreCase("getLastLogonTime")){
            shellCommand = "lastlog -u "+user+" | grep \""+user+"\" | awk '{print $(NF-5)\" \"$(NF-4)\" \"$(NF-3)\" \"$(NF-2)\" \"$(NF-1)\" \"$NF}'";
        }
        try{
            passwd = MD5Pass.DecryptString(passwd);
        }catch(Exception e){
            result = e.getMessage();
            logger.info("linuxRequest-MD5Pass.DecryptString(passwd)-exception:"+e.getMessage());
            System.out.println(e.getMessage());
        }
        result = execLinuxCommand(ip,port,passwd,shellCommand,sudoer);
        return result;
    }

    public String windowsRequest(String ip,String port,String passwd,String user,String command) {
        String result = "";
        if(command.equalsIgnoreCase("getAllUser")){
            result = sendHttpRequest(ip,port,"netUsers");
        }else if(command.equalsIgnoreCase("getPasswdModifyTime")){
            result = sendHttpRequest(ip,port,"passwordModifyInfo?userName="+user);
        }else if(command.equalsIgnoreCase("getLastLogonTime")){
            result = sendHttpRequest(ip,port,"passwordModifyInfo?userName="+user);
        }
        return result;
    }

    private String execLinuxCommand(String ip,String port,String passwd,String shellCommand,String sudoer){
        if(!sudoer.equalsIgnoreCase("root")){
            shellCommand = "sudo " + shellCommand;
        }
        String usersList = "";
        try {
            usersList = SshUtil.exec(ip, sudoer, passwd, Integer.parseInt(port), shellCommand);
        } catch (JSchException e) {
            usersList = e.getMessage();
            return usersList;
        }
        return usersList;
    }

    public String sendHttpRequest(String ip,String port,String winCommand) {
        String targetUrl = "http://"+ip+":"+port+"/"+winCommand;
        String content = null;
        try {
            content = HttpClientUtil.origHttpPost(targetUrl,"","",null);
        } catch (Exception e) {
            e.printStackTrace();
            content = e.getMessage();
            return content;
        }
        return content;
    }

}
