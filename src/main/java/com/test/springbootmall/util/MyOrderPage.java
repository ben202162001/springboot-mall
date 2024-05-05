package com.test.springbootmall.util;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyOrderPage<T> {
    int userId;
    String userName;
    String phoneNumber;
    private List<T> orders;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<T> getOrders() {
        return orders;
    }

    public void setOrders(List<T> orders) {
        this.orders = orders;
    }

}
