package com.thang.demo.service;

import com.thang.demo.response.BillDetailResponse;
import com.thang.demo.response.CartDetailResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author thangdt
 */
public interface BillDetailService {

    List<BillDetailResponse> findAllByIdBill( String idBill);
}
