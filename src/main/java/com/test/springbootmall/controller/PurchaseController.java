package com.test.springbootmall.controller;

import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.util.ErrorMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.springbootmall.service.PurchaseService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin
public class PurchaseController {
    private PurchaseService PurchaseService;
    @Autowired
    public PurchaseController(PurchaseService PurchaseService) {
        this.PurchaseService = PurchaseService;
    }
    @PostMapping("/Purchase")
    public ErrorMassage Purchase(@RequestBody Purchase Purchase) {
        System.out.println(Purchase);
        ErrorMassage ErrorMassage = PurchaseService.Purchase(Purchase);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("Purchase呼叫完成:"+dtf.format(LocalDateTime.now()));
        return ErrorMassage;
//案例
//        {
//            "user_name": "John Doe",
//                "product_id": 123,
//                "quantity": 2,
//                "totalPrice": 50,
//                "buyDate": "2024-04-15",
//                "remark": "Example remark"
//        }

    }
}
