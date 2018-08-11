package com.huangpeng.cloud.myBatisDemo.JDBCDemo;


import com.huangpeng.cloud.myBatisDemo.Test;

import java.sql.*;


public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        Test t = new Test();
        t.setNums(88);
        t.setName("huangpeng");
        System.out.println(insert(t));
    }

    public static int insert(Test test) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://118.190.21.49:3306/bootdo?useUnicode=true&amp;characterEncoding=utf8", "root", "dev123456");
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO test(nums,name) VALUES (?,?)");
            preparedStatement.setInt(1, test.getNums());
            preparedStatement.setString(2, test.getName());
            int s = preparedStatement.executeUpdate();
            connection.commit();
            return s;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static Test get(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Test test = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://118.190.21.49:3306/bootdo?useUnicode=true&amp;characterEncoding=utf8", "root", "dev123456");
            preparedStatement = connection.prepareStatement("SELECT * FROM test WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                test = new Test();
                test.setId(rs.getInt(1));
                test.setNums(rs.getInt(2));
                test.setName(rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return test;
    }
}
