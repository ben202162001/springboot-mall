package com.test.springbootmall.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestHomeController {

    @GetMapping("/")
    public String Home() {
        String list = "http://localhost:8080/AllProducts"+ "<br>" +
                "http://localhost:8080/Products"+ "<br>" +
                "http://localhost:8080/login?phone_Number=0912345678&password=password";

        return list;
    }
}
