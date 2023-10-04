package com.thang.demo.response;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author thangdt
 */
public interface BillDetailResponse {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.idProduct}")
    String getIdProduct();

    @Value("#{target.quantity}")
    int getQuantity();

    @Value("#{target.price}")
    String getPrice();

    @Value("#{target.nameProduct}")
    String getNameProduct();

    @Value("#{target.nameColor}")
    String getNameColor();

    @Value("#{target.nameSize}")
    String getNameSize();
}
