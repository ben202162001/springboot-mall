package com.test.springbootmall.dao.impl;

import com.test.springbootmall.dao.UserDao;
import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.User;
import com.test.springbootmall.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User DoLoginCheck(UserDto UserDto) {
        String sql = "SELECT * FROM account_user WHERE 1=1";

        // Adding conditions based on DTO fields
        if (UserDto.getPhone_Number() != null && !UserDto.getPhone_Number().isEmpty()) {
            sql += " AND phone_Number = '" + UserDto.getPhone_Number() + "'";
        }

        if (UserDto.getPassword() != null && !UserDto.getPassword().isEmpty()) {
            sql += " AND password = '" + UserDto.getPassword() + "'";
        }

        try {
            // Execute the query and return the result
            return jdbcTemplate.queryForObject(sql, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no user is found
            return null;
        }
    }

    @Override
    public Boolean CheckPhoneNumber(UserDto UserDto) {
        String sql = "SELECT * FROM account_user WHERE 1=1";

        // Adding conditions based on DTO fields
        if (UserDto.getPhone_Number() != null && !UserDto.getPhone_Number().isEmpty()) {
            sql += " AND phone_Number = '" + UserDto.getPhone_Number() + "'";
        }


        try {
            // Execute the query and return the result
            jdbcTemplate.queryForObject(sql, new UserRowMapper());
            return true;
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no user is found
            return false;
        }
    }

    @Override
    public User getUserData(UserDto UserDto) {
        String sql = "SELECT * FROM account_user WHERE 1=1";

        // Adding conditions based on DTO fields
        if (UserDto.getPhone_Number() != null && !UserDto.getPhone_Number().isEmpty()) {
            sql += " AND phone_Number = '" + UserDto.getPhone_Number() + "'";
        }

        if (UserDto.getPassword() != null && !UserDto.getPassword().isEmpty()) {
            sql += " AND password = '" + UserDto.getPassword() + "'";
        }

        try {
            // Execute the query and return the result
            return jdbcTemplate.queryForObject(sql, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no user is found
            return null;
        }
    }
}
