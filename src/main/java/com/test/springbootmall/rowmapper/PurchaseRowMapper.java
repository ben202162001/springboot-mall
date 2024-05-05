package com.test.springbootmall.rowmapper;

import com.test.springbootmall.model.Purchase;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseRowMapper  implements RowMapper<Purchase> {
    @Override
    public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
        Purchase purchase = new Purchase();
        purchase.setphone_number(rs.getString("phone_number"));
        purchase.setproduct_id(rs.getInt("product_id"));
        purchase.setQuantity(rs.getInt("quantity"));
        purchase.settotal_price(rs.getInt("total_price"));
        purchase.setbuy_date(rs.getDate("buy_date"));
        purchase.setRemark(rs.getString("remark"));
        return purchase;
    }
}
