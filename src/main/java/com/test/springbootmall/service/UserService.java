package com.test.springbootmall.service;

import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.User;
import com.test.springbootmall.util.ErrorMassage;

public interface UserService {
     ErrorMassage DoLogin(UserDto UserDto);
     User getUserData(UserDto UserDto);
}
