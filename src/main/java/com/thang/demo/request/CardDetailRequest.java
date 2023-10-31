package com.thang.demo.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author thangdt
 */
@Getter
@Setter
public class CardDetailRequest {

    private String idProduct;

    private String idColor;

    private String idSize;

    private int quantity;

}
