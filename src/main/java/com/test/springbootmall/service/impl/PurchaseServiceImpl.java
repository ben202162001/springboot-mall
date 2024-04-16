package com.test.springbootmall.service.impl;

import com.test.springbootmall.dao.ProductDao;
import com.test.springbootmall.model.Product;
import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.service.PurchaseService;
import com.test.springbootmall.util.ErrorMassage;
import com.test.springbootmall.dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao PurchaseDao;

    @Autowired
    private ProductDao ProductDao;

    @Autowired
    ErrorMassage ErrorMassage;
    @Override
    public ErrorMassage Purchase(Purchase purchase) {
        LocalTime dtf = LocalTime.now();
        //確認user
        if (purchase.getphone_number().equals("")||purchase.getphone_number().equals(null)) {
            ErrorMassage.setMassageStatus("fail");
            ErrorMassage.setMassage("請先登入");
            ErrorMassage.setErrorTime(dtf);
            return ErrorMassage;
        }

        //確認商品
        Product Product =ProductDao.GetProductById(purchase.getproduct_id());
        if (Product == (null)){
            ErrorMassage.setMassageStatus("fail");
            ErrorMassage.setMassage("商品不存在");
            ErrorMassage.setErrorTime(dtf);
            return ErrorMassage;
        }

        //確認商品庫存
        if (purchase.getQuantity()>Product.getStock()){
            ErrorMassage.setMassageStatus("fail");
            ErrorMassage.setMassage(purchase.getproduct_id()+"，此編號商品庫存不足");
            ErrorMassage.setErrorTime(dtf);
            return ErrorMassage;
        }
        System.out.println("此次變更資料:"+purchase);
        System.out.println("商品原本:"+Product);
        //寫入訂單
        PurchaseDao.Purchase(purchase);

        //刪除商品庫存
        PurchaseDao.PurchaseUpdateStock(purchase);

        ErrorMassage.setMassageStatus("success");
        ErrorMassage.setMassage("");
        ErrorMassage.setErrorTime(dtf);
        return ErrorMassage;
    }

}
