package com.thang.demo.response;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

/**
 * @author thangdt
 */
public interface CartDetailResponse {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.id_product_detail}")
    String getIdProductDetail();

    @Value("#{target.price}")
    BigDecimal getPrice();

    @Value("#{target.name}")
    String getName();

    @Value("#{target.name_color}")
    String getNameColor();

    @Value("#{target.name_size}")
    String getNameSize();

    @Value("#{target.quantity}")
    int getQuantity();

    @Value("#{target.quantity_max}")
    int getQuantityMax();
}

