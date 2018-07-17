package com.huangpeng.cloud.passwordDetect.controller;

import com.alibaba.fastjson.JSONObject;
import com.huangpeng.cloud.passwordDetect.service.PasswordDetectService;
import com.huangpeng.cloud.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * 任务：
 * 描述：密码探测客户端
 * 作者：@author huangpeng
 * 时间：@create 2018-01-19 上午10:29
 * 类名: PasswordDetectController
 * </pre>
 **/
@RestController
public class PasswordDetectController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PasswordDetectService pds;

    @RequestMapping(value="/netUsers",produces="text/plain;charset=UTF-8")
    public String index() {
        String result = pds.executeCmd("net user");
        JSONObject json = new JSONObject();
        json.put("data", JsonUtil.string2Json(result));
        logger.info(json.toString());
        return json.toString();
    }

    @RequestMapping(value="/passwordModifyInfo",produces="text/plain;charset=UTF-8")
    public String index(@RequestParam("userName") String userName) {
        String result = pds.executeCmd("net user "+userName);
        JSONObject json = new JSONObject();
        json.put("data", JsonUtil.string2Json(result));
        return json.toString();
    }

    @RequestMapping(value="/passMessage",produces="text/plain;charset=UTF-8")
    public String passMessage(@RequestParam("ip") String ip,
                              @RequestParam("port") String port,
                              @RequestParam("passwd") String passwd,
                              @RequestParam("user") String user,
                              @RequestParam("os") String os,
                              @RequestParam("command") String command,
                              @RequestParam("sudoer") String sudoer) {
        JSONObject json = new JSONObject();
        String result = "";
        if(os.equalsIgnoreCase("linux")){
            result = pds.linuxRequest(ip,port,passwd,user,command,sudoer);
        } else if(os.equalsIgnoreCase("windows")){
            result = pds.windowsRequest(ip,port,passwd,user,command);
        }
        json.put("data",result);
        logger.info(json.toString());
        System.out.println(json.toString());
        return json.toString();
    }

}
