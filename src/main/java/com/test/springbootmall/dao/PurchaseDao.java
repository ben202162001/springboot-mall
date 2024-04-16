package com.test.springbootmall.dao;

import com.test.springbootmall.dto.UserDto;
import com.test.springbootmall.model.Purchase;

public interface PurchaseDao {
    void Purchase(Purchase purchase);
    void PurchaseUpdateStock(Purchase purchase);

}
