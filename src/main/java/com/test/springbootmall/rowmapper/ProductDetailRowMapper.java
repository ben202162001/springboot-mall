package com.test.springbootmall.rowmapper;

import com.test.springbootmall.model.ProductDetail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDetailRowMapper implements RowMapper<ProductDetail> {
    @Override
    public ProductDetail mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(resultSet.getInt("product_id"));
        productDetail.setProductModel(resultSet.getString("product_model"));
        productDetail.setProductBrand(resultSet.getString("product_brand"));
        productDetail.setOrigin(resultSet.getString("origin"));
        productDetail.setReturnable(resultSet.getString("returnable"));
        productDetail.setFirstListingDate(resultSet.getDate("first_listing_date"));
        productDetail.setDelistingDate(resultSet.getDate("delisting_date"));
        return productDetail;
    }
}
