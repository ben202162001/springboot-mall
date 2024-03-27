package com.test.springbootmall.service.impl;

import com.test.springbootmall.dao.ProductDao;
import com.test.springbootmall.model.Product;
import com.test.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }
    @Override
    public List<Product> getProducts() {
        return productDao.findProducts();
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAllProducts();
    }
}
