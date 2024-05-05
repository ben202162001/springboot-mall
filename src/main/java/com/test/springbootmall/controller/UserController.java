package com.test.springbootmall.controller;

import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.model.User;
import com.test.springbootmall.service.UserService;
import com.test.springbootmall.util.ErrorMassage;
import com.test.springbootmall.util.MyOrderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ErrorMassage login(UserDto UserDto) {
        ErrorMassage ErrorMassage = userService.DoLogin(UserDto);
        return ErrorMassage;
    }
    @GetMapping("/getUserData")
    public User getUserData(UserDto UserDto) {
        User User = userService.getUserData(UserDto);
        return User;
    }
    @GetMapping("/members/{PhoneNumber}/orders")
    public MyOrderPage<Purchase> getMemberOrders(@PathVariable String PhoneNumber) {
        return userService.getMemberOrders(PhoneNumber);
    }
}
