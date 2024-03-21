package com.test.springbootmall;

import com.test.springbootmall.model.Product;
import com.test.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class testmysql {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;


    public List<Product> getProducts() {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, created_date, last_modified_date " +
                "FROM product";

        Map<String, Object> map = new HashMap<>();
        List<Product> productList = jdbcTemplate.query(sql, map, new ProductRowMapper());

        return productList;
    }

}
