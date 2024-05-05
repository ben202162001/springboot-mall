package com.test.springbootmall.dao;

import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.model.User;

import java.util.List;


public interface UserDao {
    User DoLoginCheck(UserDto UserDto);
    Boolean CheckPhoneNumber(UserDto UserDto);

    User getUserData(UserDto UserDto);
    List<Purchase> getMemberOrders(String PhoneNumber);
}
