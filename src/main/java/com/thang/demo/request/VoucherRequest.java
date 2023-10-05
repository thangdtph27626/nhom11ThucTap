package com.thang.demo.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author thangdt
 */
@Getter
@Setter
public class VoucherRequest {

    private String name;

    private String value;

    private Integer quantity;

    private String startDate;

    private String endDate;
}
