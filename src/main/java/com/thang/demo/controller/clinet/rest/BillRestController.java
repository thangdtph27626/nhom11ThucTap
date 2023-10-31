package com.thang.demo.controller.clinet.rest;

import com.thang.demo.controller.base.BaseController;
import com.thang.demo.entity.Bill;
import com.thang.demo.request.AddBillRequest;
import com.thang.demo.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thangdt
 */
@RestController
@RequestMapping("/api/bill")
public class BillRestController extends BaseController {


    @Autowired
    private BillService billService;

    @PostMapping
    public Bill createBill(@RequestBody AddBillRequest request){
        return  billService.createBill(session.getUserId(), request);
    }
}
