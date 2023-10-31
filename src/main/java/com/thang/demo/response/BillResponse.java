package com.thang.demo.response;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

/**
 * @author thangdt
 */
public interface BillResponse {
    @Value("#{target.stt}")
    String getStt();

    @Value("#{target.id}")
    String getId();

    @Value("#{target.code}")
    String getCode();

    @Value("#{target.created_date}")
    long getCreatedDate();

    @Value("#{target.userName}")
    String getUserName();

    @Value("#{target.type}")
    String getType();

    @Value("#{target.status_bill}")
    String getStatusBill();

    @Value("#{target.total_money}")
    BigDecimal getTotalMoney();

    @Value("#{target.item_discount}")
    BigDecimal getItemDiscount();
}
