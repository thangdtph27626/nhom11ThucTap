package com.thang.demo.response;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author thangdt
 */
public interface StatisticalDayResponse {
    @Value("#{target.totalBillToday}")
    Integer getTotalBillToday();
    @Value("#{target.totalBillAmountToday}")
    Integer getTotalBillAmountToday();
}
