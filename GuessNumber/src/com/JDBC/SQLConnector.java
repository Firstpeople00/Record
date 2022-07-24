package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnector {

    private static final String DBDDRIVER = "com.mysql.jdbc.Driver";//驱动
    private static final String DBURL = "jdbc:mysql://localhost:3306/guessnumber?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String DBUSER = "root";//用户名
    private static final String DBPASSWORD = "lovelps00";//密码
    //加载驱动
    static {
        try {
            Class.forName(DBDDRIVER);
            System.out.println("加载数据库驱动成功");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("加载驱动失败");
        }
    }

    //建立获取连接的方法
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
            System.out.println("建立数据库连接成功");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("发生连接异常");
        }
        return conn;
    }
    //建立关闭连接的方法
    public static void close(Connection conn) {
        if(conn!=null) {
            try {
                conn.close();
                System.out.println("关闭数据库连接成功");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("关闭数据库连接时发生异常");
            }
        }
    }
    //建立关闭操作的方法
    public static void close(Statement stmt) {
        if(stmt!=null) {
            try {
                stmt.close();
                System.out.println("关闭数据库操作资源成功");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("关闭数据库操作资源发生异常");
            }
        }
    }
    //建立关闭结果集的方法
    public static void close (ResultSet rs) {
        if(rs!=null) {
            try {
                rs.close();
                System.out.println("关闭结果集成功");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("关闭结果集发生异常");
            }
        }
    }
}

