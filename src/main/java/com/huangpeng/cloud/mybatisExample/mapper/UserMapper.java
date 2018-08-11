package com.huangpeng.cloud.mybatisExample.mapper;

import com.huangpeng.cloud.mybatisExample.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2018-06-20 下午4:07
 * 类名: UserMapper
 * </pre>
 **/

@Mapper
public interface UserMapper {
    List<UserEntity> getUser();
    void insert(UserEntity user);
}
