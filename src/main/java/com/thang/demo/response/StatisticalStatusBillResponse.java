package com.thang.demo.response;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author thangdt
 */
public interface StatisticalStatusBillResponse {
    @Value("#{target.statusBill}")
    String getStatusBill();
    @Value("#{target.totalStatusBill}")
    Integer getTotalStatusBill();
}
