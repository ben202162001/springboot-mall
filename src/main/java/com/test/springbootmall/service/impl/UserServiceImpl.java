package com.test.springbootmall.service.impl;

import com.test.springbootmall.dao.UserDao;
import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.User;
import com.test.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserDao UserDao;

    @Autowired
    public UserServiceImpl(UserDao UserDao) {
        this.UserDao = UserDao;
    }


    @Override
    public User DoLogin(UserDto UserDto) {
        Boolean isExsitAccount =UserDao.CheckPhoneNumber(UserDto);

        if (isExsitAccount.equals(true)){
            System.out.println(UserDto.getPhone_Number()+" "+UserDto.getPassword()+" 帳號存在");
            return UserDao.DoLogin(UserDto);
        }else {
            System.out.println(UserDto.getPhone_Number()+" "+UserDto.getPassword()+" 帳號不存在");
            return UserDao.DoLogin(UserDto);

        }

    }

}
