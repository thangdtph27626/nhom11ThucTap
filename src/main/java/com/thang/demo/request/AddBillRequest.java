package com.thang.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author thangdt
 */
@Getter
@Setter
public class AddBillRequest {

    private String code;
    private String phoneNumber;
    private String address;
    private String userName;
    private String itemDiscount;
    private String totalMoney;
    private String moneyShip;
    private String note;
    private String idVoucher;
}
