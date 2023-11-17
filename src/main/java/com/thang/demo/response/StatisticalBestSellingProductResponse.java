package com.thang.demo.response;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

/**
 * @author thangdt
 */
public interface StatisticalBestSellingProductResponse {
    @Value("#{target.image}")
    String getImage();
    @Value("#{target.nameProduct}")
    String getNameProduct();
    @Value("#{target.price}")
    BigDecimal getPrice();
    @Value("#{target.sold}")
    BigDecimal getSold();
    @Value("#{target.sales}")
    BigDecimal getSales();
}