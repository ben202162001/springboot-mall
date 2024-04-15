package com.test.springbootmall.service;

import com.test.springbootmall.model.Purchase;
import com.test.springbootmall.util.ErrorMassage;

public interface PurchaseService {
    ErrorMassage Purchase(Purchase Purchase);

}
