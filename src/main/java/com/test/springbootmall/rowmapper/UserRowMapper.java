package com.test.springbootmall.rowmapper;

import com.test.springbootmall.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(resultSet.getInt("user_Id"));
            user.setUserName(resultSet.getString("user_Name"));
            user.setPassword(resultSet.getString("password"));
            user.setPhoneNumber(resultSet.getString("phone_Number"));
            user.setCreateTime(resultSet.getDate("create_Time"));
            user.setEditTime(resultSet.getDate("edit_Time"));
            return user;
        }

}
