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
        String sql = "INSERT INTO product_order (user_name, product_id, quantity, total_price, buy_date, remark) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql, purchase.getuser_name(), purchase.getproduct_id(), purchase.getQuantity(),
                    purchase.gettotal_price(), purchase.getbuy_date(), purchase.getRemark());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
