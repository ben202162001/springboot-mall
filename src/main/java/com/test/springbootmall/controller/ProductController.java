package com.test.springbootmall.controller;

import com.test.springbootmall.model.Product;
import com.test.springbootmall.service.ProductService;
import com.test.springbootmall.util.ProductPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@RestController
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/AllProducts")
    public ProductPage<Product> AllProducts() {
        List<Product> ProductList= productService.getAllProducts();
        ProductPage<Product> ProductPage = new ProductPage<>();
        //先寫死筆數限制跟起算筆數，之後再回來改
        ProductPage.setLimit(100);//一頁顯示多少筆
        ProductPage.setOffset(10);//顯示的從第幾筆開始算
        ProductPage.setTatol(1000);//總數幾筆
        ProductPage.setResults(ProductList);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("AllProducts呼叫完成:"+dtf.format(LocalDateTime.now()));
        return ProductPage;
    }
    @GetMapping("/Products")
    public ProductPage<Product> Products() {
        List<Product> ProductList= productService.getProducts();
        ProductPage<Product> ProductPage = new ProductPage<>();
        //先寫死筆數限制跟起算筆數，之後再回來改
        ProductPage.setLimit(100);//一頁顯示多少筆
        ProductPage.setOffset(10);//顯示的從第幾筆開始算
        ProductPage.setTatol(1000);//總數幾筆
        ProductPage.setResults(ProductList);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("Products呼叫完成:"+dtf.format(LocalDateTime.now()));
        return ProductPage;
    }

}
