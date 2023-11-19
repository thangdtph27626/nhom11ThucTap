package com.thang.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product_Detail {
//    private String id;
    private String description;
    private BigDecimal price;
    private int quantity;
    private String idCategory;
    private String idProduct;
    private String idColor;
    private String idSize;
    private String idForm;
}
