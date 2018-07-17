package com.huangpeng.cloud.mybatisExample.controller;

import com.alibaba.fastjson.JSONObject;
import com.huangpeng.cloud.mybatisExample.entity.UserEntity;
import com.huangpeng.cloud.mybatisExample.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2018-06-20 下午4:05
 * 类名: UserController
 * </pre>
 **/

@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @GetMapping("getUser")
    @Transactional
    public List<UserEntity> getUser(){
        logger.info("获取用户数据");
        return userService.getUser();
    }
    @Transactional
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insertUser(@RequestBody UserEntity u) {
        try {
            userService.insert(u);
            return JSONObject.toJSON(userService.getUser()).toString();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return JSONObject.toJSON(e).toString();
        }
    }
}
