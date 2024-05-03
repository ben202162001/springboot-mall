package com.test.springbootmall.dto;

import java.util.Date;

public class ProductDetailDto {
    private int productId;
    private Date search_day;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getSearch_day() {
        return search_day;
    }

    public void setSearch_day(Date search_day) {
        this.search_day = search_day;
    }
}
