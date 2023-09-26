package com.thang.demo.response;

import com.thang.demo.entity.Product;
import com.thang.demo.entity.ProductDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

/**
 * @author thangdt
 */
@Projection(types = {Product.class, ProductDetail.class})
public interface ProductDetailResponse {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.quantity}")
    int getQuantity();

    @Value("#{target.gender}")
    String getGender();

    @Value("#{target.price}")
    BigDecimal getPrice();

    @Value("#{target.name_product}")
    String getName();

    @Value("#{target.name_category}")
    String getCategory();

    @Value("#{target.name_color}")
    String getColor();

    @Value("#{target.id_color}")
    String getIdColor();

    @Value("#{target.name_form}")
    String getForm();

    @Value("#{target.name_size}")
    String getSize();

    @Value("#{target.id_size}")
    String getIdSize();
}
