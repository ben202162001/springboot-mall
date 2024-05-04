package com.test.springbootmall.service.impl;

import com.test.springbootmall.dao.ProductDao;
import com.test.springbootmall.dto.ProductDetailDto;
import com.test.springbootmall.dto.ProductDto;
import com.test.springbootmall.model.Product;
import com.test.springbootmall.model.ProductDetail;
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
    public List<Product> getProducts(ProductDto ProductDto) {
        return productDao.findProducts(ProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAllProducts();
    }
    @Override
    public int countProducts(ProductDto productDto) {
        return productDao.countProducts(productDto);
    }

    @Override
    public ProductDetail getProductDetail(ProductDetailDto ProductDetailDto) {
        return productDao.getProductDetail(ProductDetailDto);
    }
    @Override
    public Product getProduct(ProductDetailDto ProductDetailDto) {
        return productDao.getProduct(ProductDetailDto);
    }

    ;
}
