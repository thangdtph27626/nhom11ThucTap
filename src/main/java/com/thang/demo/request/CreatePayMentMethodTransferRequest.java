package com.thang.demo.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author thangdt
 */
@Getter
@Setter
public class CreatePayMentMethodTransferRequest {

    public String vnp_Ammount ;
    public String vnp_OrderInfo = "Thanh toán hóa đơn";
    public String vnp_OrderType = "Thanh toán hóa đơn";
    public String vnp_TxnRef;

}