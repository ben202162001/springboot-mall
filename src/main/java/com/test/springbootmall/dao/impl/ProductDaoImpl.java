package com.test.springbootmall.dao.impl;

import com.test.springbootmall.dao.ProductDao;
import com.test.springbootmall.dto.ProductDto;
import com.test.springbootmall.model.Product;
import com.test.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
}
