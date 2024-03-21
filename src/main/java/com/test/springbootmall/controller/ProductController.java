package com.test.springbootmall.controller;

import com.test.springbootmall.model.Product;
import com.test.springbootmall.service.ProductService;
import com.test.springbootmall.util.ProductPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public ProductPage<Product> getProducts() {
        List<Product> ProductList= productService.getProducts();
        ProductPage<Product> ProductPage = new ProductPage<>();
        ProductPage.setLimit(100);
        ProductPage.setOffset(10);
        ProductPage.setResults(ProductList);

        return ProductPage;
    }

}
