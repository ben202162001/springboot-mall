package com.test.springbootmall.dao.impl;

import com.test.springbootmall.dao.PurchaseDao;
import com.test.springbootmall.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void Purchase(Purchase purchase) {
        String sql = "INSERT INTO product_order (phone_number, product_id, quantity, total_price, buy_date, remark) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, purchase.getphone_number(), purchase.getproduct_id(), purchase.getQuantity(),
                    purchase.gettotal_price(), purchase.getbuy_date(), purchase.getRemark());

    }
    @Override
    public void PurchaseUpdateStock(Purchase purchase) {
        String sql = "UPDATE product SET stock = stock - ? WHERE product_id = ?";
        int rowsUpdated = jdbcTemplate.update(sql, purchase.getQuantity(), purchase.getproduct_id());
    }
}
