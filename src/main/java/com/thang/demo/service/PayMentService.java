package com.thang.demo.service;

import com.thang.demo.request.CreatePayMentMethodTransferRequest;
import jakarta.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;

/**
 * @author thangdt
 */
public interface PayMentService {

    String createVnpay(CreatePayMentMethodTransferRequest createPayMentMethodTransferRequest, HttpServletRequest request) throws UnsupportedEncodingException;
}
