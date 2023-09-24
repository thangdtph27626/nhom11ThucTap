package com.thang.demo.response;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author thangdt
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceProductRespone {

    private BigDecimal price;

    private String size;

    private String color;

}
