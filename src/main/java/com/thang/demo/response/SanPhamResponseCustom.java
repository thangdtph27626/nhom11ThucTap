package com.thang.demo.response;

import com.thang.demo.entity.*;
import com.thang.demo.infrastructure.constant.GenderProductDetail;
import com.thang.demo.infrastructure.constant.Status;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

/**
 * @author thangdt
 */
@Projection(types = {Product.class, ProductDetail.class})
public interface SanPhamResponseCustom {

    @Value("#{target.id}")
     String getId();

    @Value("#{target.price_min}")
     BigDecimal getPriceMin();

    @Value("#{target.price_max}")
    BigDecimal getPriceMax();

    @Value("#{target.quantity}")
     Integer getQuantity();

    @Value("#{target.name}")
    String getName();
}
