package com.huangpeng.cloud.mybatisExample.serviceImpl;

import com.huangpeng.cloud.mybatisExample.entity.UserEntity;
import com.huangpeng.cloud.mybatisExample.mapper.UserMapper;
import com.huangpeng.cloud.mybatisExample.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2018-06-20 下午4:06
 * 类名: UserService
 * </pre>
 **/

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    //获取用户的信息
    public List<UserEntity> getUser(){
        List<UserEntity> userList = new ArrayList<>();
        userList = userMapper.getUser();
        return userList;
    }

    public void insert(UserEntity user){
        userMapper.insert(user);
    }
}