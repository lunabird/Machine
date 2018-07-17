package com.huangpeng.cache.test;

import java.io.Serializable;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2018-06-23 下午2:44
 * 类名: User
 * </pre>
 **/

public class User implements Serializable {
    String userName;
    int age;

    public User(){

    }

    public User(String userName,int age){
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
