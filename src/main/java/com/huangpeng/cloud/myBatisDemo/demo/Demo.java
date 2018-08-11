package com.huangpeng.cloud.myBatisDemo.demo;

import com.huangpeng.cloud.myBatisDemo.Test;
import com.huangpeng.cloud.myBatisDemo.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Demo {
    public static SqlSession getSqlSession() throws FileNotFoundException {
        //配置文件
        InputStream configFile = new FileInputStream(
                "/Users/huangpeng/workspace/javaproj/github/Machine/src/main/java/com/huangpeng/cloud/myBatisDemo/demo/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        //加载配置文件得到SqlSessionFactory
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) throws FileNotFoundException {
        SqlSession session =  getSqlSession();
        TestMapper testMapper = session.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println("test=="+test.getId()+","+test.getNums()+","+test.getName());
        Test t1 = new Test();
        t1.setNums(12223);
        t1.setName("kyeeee");
        testMapper.insertSelective(t1);
        session.commit();
        session.close();
    }
}
