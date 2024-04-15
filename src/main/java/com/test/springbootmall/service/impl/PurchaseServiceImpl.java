package com.test.springbootmall.service.impl;

import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.service.PurchaseService;
import com.test.springbootmall.util.ErrorMassage;
import com.test.springbootmall.dao.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseDao PurchaseDao;
    @Autowired
    public PurchaseServiceImpl(PurchaseDao purchaseDao) {
        this.PurchaseDao = purchaseDao;
    }
    @Autowired
    ErrorMassage ErrorMassage;
    @Override
    public ErrorMassage Purchase(Purchase purchase) {
        LocalTime dtf = LocalTime.now();
        PurchaseDao.Purchase(purchase); // 正確的調用實例方法
        ErrorMassage.setMassageStatus("success");
        ErrorMassage.setMassage("");
        ErrorMassage.setErrorTime(dtf);
        return ErrorMassage;
    }

}
