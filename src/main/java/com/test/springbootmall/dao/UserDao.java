package com.test.springbootmall.dao;

import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.User;


public interface UserDao {
    User DoLogin(UserDto UserDto);
    Boolean CheckPhoneNumber(UserDto UserDto);
}
