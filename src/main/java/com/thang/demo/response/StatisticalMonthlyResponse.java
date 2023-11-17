package com.thang.demo.response;
import org.springframework.beans.factory.annotation.Value;
/**
 * @author thangdt
 */
public interface StatisticalMonthlyResponse {
    @Value("#{target.totalBill}")
    Integer getTotalBill();

    @Value("#{target.totalBillAmount}")
    Integer getTotalBillAmount();

    @Value("#{target.totalProduct}")
    Integer getTotalProduct();
}
