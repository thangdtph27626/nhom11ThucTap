package com.thang.demo.service;



import com.thang.demo.request.FindBillDateRequest;
import com.thang.demo.response.*;

import java.util.List;

/**
 * @author thangdt
 */
public interface StatisticalService {
    List<StatisticalDayResponse> getAllStatisticalDay();
    List<StatisticalMonthlyResponse> getAllStatisticalMonth();
    List<StatisticalStatusBillResponse> getAllStatisticalStatusBill();
    List<StatisticalBestSellingProductResponse> getAllStatisticalBestSellingProduct();
    List<StatisticalBillDateResponse> getAllStatisticalBillDate(final FindBillDateRequest findBillDateRequest);
    List<StatisticalProductDateResponse> getAllStatisticalProductDate(final FindBillDateRequest findBillDateRequest);

}
