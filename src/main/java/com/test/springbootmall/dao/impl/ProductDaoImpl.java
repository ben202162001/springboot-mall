package com.test.springbootmall.dao.impl;

import com.test.springbootmall.dao.ProductDao;
import com.test.springbootmall.dto.ProductDetailDto;
import com.test.springbootmall.dto.ProductDto;
import com.test.springbootmall.model.Product;
import com.test.springbootmall.model.ProductDetail;
import com.test.springbootmall.rowmapper.ProductDetailRowMapper;
import com.test.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }
    @Override
    public List<Product> findProducts(ProductDto productDto) {
        String sql = "SELECT * FROM product WHERE 1=1";

        // Adding conditions based on DTO fields
        if (productDto.getCategory() != null && !productDto.getCategory().isEmpty()) {
            sql += " AND category = '" + productDto.getCategory() + "'";
        }

        if (productDto.getLow_price() > 0) {
            sql += " AND price >= " + productDto.getLow_price();
        }

        if (productDto.getHigh_price() > 0) {
            sql += " AND price <= " + productDto.getHigh_price();
        }

        if (productDto.getSort() != null && !productDto.getSort().isEmpty()) {
            sql += " ORDER BY " + productDto.getSort();
        }
        // Applying limit and offset
        if (productDto.getLimit() > 0) {
            sql += " LIMIT " + productDto.getLimit();
        }

        if (productDto.getOffset() > 0) {
            sql += " OFFSET " + productDto.getOffset();
        }
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public int countProducts(ProductDto productDto) {
        String sql = "SELECT COUNT(*) FROM product WHERE 1=1";

        // Adding conditions based on DTO fields
        if (productDto.getCategory() != null && !productDto.getCategory().isEmpty()) {
            sql += " AND category = '" + productDto.getCategory() + "'";
        }

        if (productDto.getLow_price() > 0) {
            sql += " AND price >= " + productDto.getLow_price();
        }

        if (productDto.getHigh_price() > 0) {
            sql += " AND price <= " + productDto.getHigh_price();
        }

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Product GetProductById(int product_id) {
        String sql = "SELECT * FROM product WHERE 1=1";
        sql += " AND product_id = '" + product_id + "'";

        try {
            return jdbcTemplate.queryForObject(sql, new ProductRowMapper());
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no user is found
            Product Product = null;
            return Product;
        }

    }

    @Override
    public ProductDetail getProductDetail(ProductDetailDto ProductDetailDto) {
        String sql = "SELECT * FROM product_detail WHERE 1=1";
        sql += " AND product_id = '" + ProductDetailDto.getProductId() + "'";

        try {
            return jdbcTemplate.queryForObject(sql, new ProductDetailRowMapper());
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no user is found
            ProductDetail ProductDetail = null;
            return ProductDetail;
        }

    }

    @Override
    public Product getProduct(ProductDetailDto ProductDetailDto) {
        String sql = "SELECT * FROM product WHERE 1=1";
        sql += " AND product_id = '" + ProductDetailDto.getProductId() + "'";

        try {
            return jdbcTemplate.queryForObject(sql, new ProductRowMapper());
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no user is found
            Product Product = null;
            return Product;
        }

    }

}
