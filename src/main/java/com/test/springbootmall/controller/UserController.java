package com.test.springbootmall.controller;

import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.User;
import com.test.springbootmall.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public ResponseEntity<User> login(UserDto UserDto) {
        String phoneNumber = UserDto.getPhone_Number();
        String password = UserDto.getPassword();

        if (phoneNumber == null || password == null) {
            return ResponseEntity.badRequest().body(null);
        }

        User user = userService.DoLogin(UserDto);
        if (user == null || !user.getPassword().equals(password)) {
            return ResponseEntity.status(401).body(null);
        }

        return ResponseEntity.ok(user);
    }
}
