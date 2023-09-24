package com.thang.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author thangdt
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuantityProductResponse {

    private int quantity;

    private String size;

    private String color;


}
