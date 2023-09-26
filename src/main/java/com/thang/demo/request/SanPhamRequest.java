package com.thang.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author thangdt
 */
@Getter
@Setter
public class SanPhamRequest {

    private String name;

    private BigDecimal priceMin ;

    private BigDecimal priceMax ;

    private String color;

    private String form;

    private String category;

    private String size;
}
