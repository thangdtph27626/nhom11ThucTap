package com.thang.demo.service;

import com.thang.demo.entity.Bill;
import com.thang.demo.request.AddBillRequest;

/**
 * @author thangdt
 */
public interface BillService {

    Bill createBill(String idUser, AddBillRequest request);
}
