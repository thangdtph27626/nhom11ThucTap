package com.thang.demo.response;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author thangdt
 */
public interface StatisticalBillDateResponse {
    @Value("#{target.billDate}")
    Long getBillDate();

    @Value("#{target.totalBillDate}")
    Integer getTotalBillDate();
}
