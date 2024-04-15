package com.test.springbootmall.model;

import java.util.Date;

public class Purchase {
    private String user_name;
    private int product_id;
    private int quantity;
    private int total_price;
    private Date buy_date;
    private String remark;

    public Purchase (String user_name, int product_id, int quantity, int total_price, Date buy_date, String remark) {
        this.user_name = user_name;
        this.product_id = product_id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.buy_date = buy_date;
        this.remark = remark;
    }

    // Getters and Setters
    public String getuser_name() {
        return user_name;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getproduct_id() {
        return product_id;
    }

    public void setproduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int gettotal_price() {
        return total_price;
    }

    public void settotal_price(int total_price) {
        this.total_price = total_price;
    }

    public Date getbuy_date() {
        return buy_date;
    }

    public void setbuy_date(Date buy_date) {
        this.buy_date = buy_date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "user_name='" + user_name + '\'' +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", total_price=" + total_price +
                ", buy_date=" + buy_date +
                ", remark='" + remark + '\'' +
                '}';
    }
}
