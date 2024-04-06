package com.test.springbootmall.service;

import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.User;

public interface UserService {
     User DoLogin(UserDto UserDto);
}
