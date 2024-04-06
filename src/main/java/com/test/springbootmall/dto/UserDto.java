package com.test.springbootmall.dto;

public class UserDto {
    private String Phone_Number;
    private String password;

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
