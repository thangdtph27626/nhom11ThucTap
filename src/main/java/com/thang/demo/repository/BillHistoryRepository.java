package com.thang.demo.repository;

import com.thang.demo.entity.Bill;
import com.thang.demo.entity.BillHistory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author thangdt
 */
public interface BillHistoryRepository extends JpaRepository<BillHistory, String> {

    List<BillHistory> findAllByBill(Bill bill, Sort sort);
}
