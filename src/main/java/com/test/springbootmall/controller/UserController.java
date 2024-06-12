package com.test.springbootmall.controller;

import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.model.User;
import com.test.springbootmall.model.UserForHibernate;
import com.test.springbootmall.service.UserService;
import com.test.springbootmall.util.ErrorMassage;
import com.test.springbootmall.util.MyOrderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
//    @PostMapping("/getUserDataByHibernate")
//    public UserForHibernate getUserDataByHibernate(@RequestBody UserDto UserDto) {
//        System.out.println(UserDto.getPhone_Number());
//        return userService.getUserDataByHibernate(UserDto);
//    }
    @GetMapping("/getUserDataByHibernateGet/{PhoneNumber}")
    public UserForHibernate getUserDataByHibernate(@PathVariable String PhoneNumber) {
        UserDto UserDto = new UserDto();
        UserDto.setPhone_Number(PhoneNumber);
        return userService.getUserDataByHibernate(UserDto);
    }
}
