package com.thang.demo.service;

import com.thang.demo.entity.Voucher;
import com.thang.demo.request.VoucherRequest;

import java.util.List;

/**
 * @author thangdt
 */
public interface VoucherService {

    List<Voucher> findAllByEndDateIsLessThan();

    List<Voucher> getAll();

    Voucher cretaeVoucher(VoucherRequest request);

    Voucher updateVoucher(String id, VoucherRequest request);

    boolean changStatusVoucher(String id);
}
