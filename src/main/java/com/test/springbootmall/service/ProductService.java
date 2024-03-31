package com.test.springbootmall.service;

import com.test.springbootmall.dto.ProductDto;
import com.test.springbootmall.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductDto ProductDto);
    List<Product> getAllProducts();
    int countProducts(ProductDto productDto);
}
