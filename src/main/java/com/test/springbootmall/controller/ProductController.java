package com.test.springbootmall.controller;

import com.test.springbootmall.dto.ProductDto;
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
        ProductPage.setResults(ProductList);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("AllProducts呼叫完成:"+dtf.format(LocalDateTime.now()));
        return ProductPage;
    }
    @GetMapping("/Products")
    public ProductPage<Product> Products(ProductDto ProductDto) {

        ProductPage<Product> ProductPage = new ProductPage<>();
        ProductPage.setTatol(productService.countProducts(ProductDto));
        if (ProductPage.getTatol() == 0 ){
            System.out.println("取得筆數為0，不應該繼續跑");
        }

        List<Product> ProductList= productService.getProducts(ProductDto);
        ProductPage.setResults(ProductList);
        ProductPage.setLimit(ProductDto.getLimit());
        ProductPage.setOffset(ProductDto.getOffset());
        ProductPage.setSort(ProductDto.getSort());


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("-------------------------------------");
        System.out.println("Products呼叫完成:"+dtf.format(LocalDateTime.now()));
        System.out.println("傳入Limit:"+ProductDto.getLimit());
        System.out.println("傳入offset:"+ProductDto.getOffset());
        System.out.println("傳入Category:"+ProductDto.getCategory());
        System.out.println("傳入Low_price:"+ProductDto.getLow_price());
        System.out.println("傳入High_price:"+ProductDto.getHigh_price());
        System.out.println("傳入Sort:"+ProductDto.getSort());
        System.out.println("");
        System.out.println("傳出Limit:"+ProductPage.getLimit());
        System.out.println("傳出Offset:"+ProductPage.getOffset());
        System.out.println("傳出Tatol:"+ProductPage.getTatol());
        System.out.println("傳出Sort:"+ProductPage.getSort());
        System.out.println("-------------------------------------");
        return ProductPage;
    }

}
