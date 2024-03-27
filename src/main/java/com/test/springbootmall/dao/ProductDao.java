package com.test.springbootmall.dao;

import com.test.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findProducts();
    List<Product> findAllProducts();
}
