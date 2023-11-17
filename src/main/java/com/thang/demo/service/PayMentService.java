package com.thang.demo.service;

import com.thang.demo.entity.PaymentsMethod;
import com.thang.demo.request.CreatePayMentMethodTransferRequest;
import com.thang.demo.request.PayMentVnpayRequest;
import jakarta.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;

/**
 * @author thangdt
 */
public interface PayMentService {

    String createVnpay(CreatePayMentMethodTransferRequest createPayMentMethodTransferRequest, HttpServletRequest request) throws UnsupportedEncodingException;

     boolean paymentSuccess(String idEmployees, PayMentVnpayRequest request);

     PaymentsMethod findByCodeBill(String code);

     PaymentsMethod findByBill(String idBill);
}
