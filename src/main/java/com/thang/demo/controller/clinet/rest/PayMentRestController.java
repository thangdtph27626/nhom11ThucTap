package com.thang.demo.controller.clinet.rest;

import com.thang.demo.request.CreatePayMentMethodTransferRequest;
import com.thang.demo.service.PayMentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * @author thangdt
 */
@RestController
@RequestMapping("/payment")
public class PayMentRestController {

    @Autowired
    private PayMentService payMentService;

    @PostMapping("")
    public String getAllProductInCart(@RequestBody CreatePayMentMethodTransferRequest createPayMentMethodTransferRequest, HttpServletRequest request) {

        try {
            return payMentService.createVnpay(createPayMentMethodTransferRequest,request);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
