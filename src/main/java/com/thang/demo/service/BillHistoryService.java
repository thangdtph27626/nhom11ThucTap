package com.thang.demo.service;

import com.thang.demo.entity.BillHistory;

import java.util.List;

/**
 * @author thangdt
 */
public interface BillHistoryService {

    List<BillHistory> findAllByBill(String idBill);
}
