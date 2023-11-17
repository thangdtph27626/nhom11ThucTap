package com.thang.demo.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author thangdt
 */
@Getter
@Setter
public class UpdateQuantityInCartRequest {

    private String id;
    private int quantity;
}
