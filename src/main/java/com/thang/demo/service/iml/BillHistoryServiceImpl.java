package com.thang.demo.service.iml;

import com.thang.demo.entity.Bill;
import com.thang.demo.entity.BillHistory;
import com.thang.demo.repository.BillHistoryRepository;
import com.thang.demo.repository.BillRepository;
import com.thang.demo.service.BillHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author thangdt
 */

@Service
public class BillHistoryServiceImpl implements BillHistoryService {

    @Autowired
    private BillHistoryRepository billHistoryRepository;

    @Autowired
    private BillRepository billRepository;


    @Override
    public List<BillHistory> findAllByBill(String idBill) {
        Optional<Bill> bill = billRepository.findById(idBill);
        return billHistoryRepository.findAllByBill(bill.get(), Sort.by(Sort.Direction.ASC, "createdDate"));
    }
}
