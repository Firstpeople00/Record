package com.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {

    static Connection conn = null;
    static {
        conn = SQLConnector.getConnection();//操作前获取连接
    }
    //定义更新操作的方法
    public static int executeUpdate(String sql) {
        int rows = 0;
        try {
            Statement stmt = conn.createStatement();//获取操作数据库对象
            rows = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("更新数据库操作发生异常");
        }
        return rows;
    }
    //使用预编译语句更新方法
    public static int executeUpdate(String sql,Object[]params) {
        int rows = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for(int i = 0;i<params.length;i++) {
                pstmt.setObject(i+1, params[i]);
            }
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("使用预编译语句更新数据库操作发生异常");
        }
        return rows;
    }
    //查询数据方法
    public static ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("查询数据操作发生异常");
        }
        return rs;
    }

    public static ResultSet executeQuery(String sql,Object[]params) {
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for(int i = 0;i<params.length;i++) {
                pstmt.setObject(i+1, params[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("使用预编译语句查询数据操作发生异常");
        }
        return rs;
    }

}

