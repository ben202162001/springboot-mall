package com.test.springbootmall.dto;

public class ProductDto {

    private int limit;
    private int offset;
    private String category;
    private int low_price;
    private int high_price;
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getLow_price() {
        return low_price;
    }

    public void setLow_price(int low_price) {
        this.low_price = low_price;
    }

    public int getHigh_price() {
        return high_price;
    }

    public void setHigh_price(int high_price) {
        this.high_price = high_price;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
