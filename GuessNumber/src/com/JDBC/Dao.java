package com.JDBC;

import com.til.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Dao {

    public boolean register(String name,String password,String userId){
        boolean b = false;
        String sql = "insert into user (user_id,name,password) values ('"+userId+"','"+name+"','"+password+"')";
        SQL.executeUpdate(sql);
        b = true;
        return b;
    }

    public boolean logIn(String id,String password) {
        boolean b = false;
        while (true) {
            try {
                String selectSql2 = "select * from user where user_id='" + id + "'and password='" + password + "'";
                ResultSet rs2 = SQL.executeQuery(selectSql2);
                if (!rs2.next()) {
                    System.out.println("密码错误");
                    break;
                } else {
                    System.out.println("密码正确");
                    b = true;
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public boolean update(String userID,int score){
        boolean b = false;
        String sql = "update user set score = "+score+" where user_id = '"+userID+"'";
        SQL.executeUpdate(sql);
        b = true;
        return b;
    }

    public LinkedList<User> getOrder(){
        LinkedList<User> linkedList = new LinkedList<User>();
        String sql = "select user_id,name,score from user order by score";
        ResultSet rs = SQL.executeQuery(sql);
        try {
            while(rs.next()) {
                User user = new User();
                user.setUser_id(rs.getString(1));
                user.setName(rs.getString("name"));
                user.setScore(rs.getInt("score"));
                linkedList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return linkedList;
    }

}
