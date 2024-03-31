package com.test.springbootmall.dao;

import com.test.springbootmall.dto.ProductDto;
import com.test.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findProducts(ProductDto ProductDto);
    List<Product> findAllProducts();
    int countProducts(ProductDto productDto);
}
