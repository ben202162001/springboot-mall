package com.test.springbootmall.model;

import lombok.Data;

import java.util.Date;
@Data
public class Purchase {
    String phone_number;
    private int product_id;
    private int quantity;
    private int total_price;
    private Date buy_date;
    private String remark;

    public Purchase (String phone_number, int product_id, int quantity, int total_price, Date buy_date, String remark) {
        this.phone_number = phone_number;
        this.product_id = product_id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.buy_date = buy_date;
        this.remark = remark;
    }

    // Getters and Setters
    public String getphone_number() {
        return phone_number;
    }

    public void setphone_number(String phone_number) {
        this.phone_number = phone_number;
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
                "phone_number='" + phone_number + '\'' +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", total_price=" + total_price +
                ", buy_date=" + buy_date +
                ", remark='" + remark + '\'' +
                '}';
    }
}
