package com.example.dao;

import com.example.model.User;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with Intellij IDEA
 * Description:
 * User : 花朝
 * Date : 2021-01-05
 * Time : 17:38
 */
public class Login {
    public static User queryDAO(String username){
        try (Connection connection = JDBCUtil.getConnection()){
            String sql = "select username ,password from user where username = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,username);
                try (ResultSet rs = ps.executeQuery()){
                    User user = null;
                    while (rs.next()){
                        user = new User();
                        user.setName(username);
                        user.setPassword(rs.getString("password"));
                    }
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return null;
        }

    }

}
