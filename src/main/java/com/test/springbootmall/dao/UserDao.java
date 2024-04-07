package com.test.springbootmall.dao;

import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.User;


public interface UserDao {
    User DoLoginCheck(UserDto UserDto);
    Boolean CheckPhoneNumber(UserDto UserDto);

    User getUserData(UserDto UserDto);
}
