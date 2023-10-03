package com.thang.demo.service;

import com.thang.demo.entity.Bill;
import com.thang.demo.entity.User;
import com.thang.demo.request.AddBillRequest;
import com.thang.demo.response.CustomBillByUserResponse;

import java.util.List;

/**
 * @author thangdt
 */
public interface BillService {

    Bill createBill(String idUser, AddBillRequest request);

    List<CustomBillByUserResponse> findAllByUser(String idUser);
}
