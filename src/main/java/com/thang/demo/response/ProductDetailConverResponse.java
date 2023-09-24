package com.thang.demo.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author thangdt
 */
@Getter
@Setter
public class ProductDetailConverResponse {

    private String id;

    private List<QuantityProductResponse> quantitys;

    private String gender;

    private List<PriceProductRespone> prices;

    private String name;

    private String category;

    private List<SimpleResponse> colors;

    private String form;

    private List<SimpleResponse> sizes;


}
