package com.test.springbootmall.dao;

import com.test.springbootmall.dto.ProductDetailDto;
import com.test.springbootmall.dto.ProductDto;
import com.test.springbootmall.model.Product;
import com.test.springbootmall.model.ProductDetail;

import java.util.List;

public interface ProductDao {
    List<Product> findProducts(ProductDto ProductDto);
    List<Product> findAllProducts();
    int countProducts(ProductDto productDto);
    Product GetProductById(int product_id);
    ProductDetail getProductDetail(ProductDetailDto ProductDetailDto);
    Product getProduct(ProductDetailDto ProductDetailDto);
}
