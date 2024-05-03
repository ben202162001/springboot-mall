package com.test.springbootmall.model;

import lombok.Data;

import java.util.Date;
@Data
public class ProductDetail {
    private int productId;
    private String productModel;
    private String productBrand;
    private String origin;
    private String returnable;
    private Date firstListingDate;
    private Date delistingDate;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getReturnable() {
        return returnable;
    }

    public void setReturnable(String returnable) {
        this.returnable = returnable;
    }

    public Date getFirstListingDate() {
        return firstListingDate;
    }

    public void setFirstListingDate(Date firstListingDate) {
        this.firstListingDate = firstListingDate;
    }

    public Date getDelistingDate() {
        return delistingDate;
    }

    public void setDelistingDate(Date delistingDate) {
        this.delistingDate = delistingDate;
    }
}
