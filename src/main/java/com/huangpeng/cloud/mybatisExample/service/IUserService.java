package com.huangpeng.cloud.mybatisExample.service;

import com.huangpeng.cloud.mybatisExample.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> getUser();
    void insert(UserEntity user);
}
