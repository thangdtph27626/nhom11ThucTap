package com.thang.demo.service.iml;

import com.thang.demo.repository.BillDetailRepository;
import com.thang.demo.response.BillDetailResponse;
import com.thang.demo.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thangdt
 */
@Service
public class BillDetailServiceImpl implements BillDetailService {

    @Autowired
    private BillDetailRepository billDetailRepository;

    @Override
    public List<BillDetailResponse> findAllByIdBill(String idBill) {
        return billDetailRepository.findAllByIdBill(idBill);
    }
}
