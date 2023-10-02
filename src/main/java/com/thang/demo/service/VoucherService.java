package com.thang.demo.service;

import com.thang.demo.entity.Voucher;

import java.util.List;

/**
 * @author thangdt
 */
public interface VoucherService {
    List<Voucher> findAllByEndDateIsLessThan();
}
