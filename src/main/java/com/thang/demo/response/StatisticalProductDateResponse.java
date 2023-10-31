package com.thang.demo.response;
import org.springframework.beans.factory.annotation.Value;
/**
 * @author thangdt
 */
public interface StatisticalProductDateResponse {
    @Value("#{target.billDate}")
    Long getBillDate();

    @Value("#{target.totalProductDate}")
    Integer getTotalProductDate();
}
