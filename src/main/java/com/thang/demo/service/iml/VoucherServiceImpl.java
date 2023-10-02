package com.thang.demo.service.iml;

import com.thang.demo.entity.Voucher;
import com.thang.demo.repository.VoucherRepository;
import com.thang.demo.service.VoucherService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * @author thangdt
 */
@Service
@Transactional
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public List<Voucher> findAllByEndDateIsLessThan() {
        return voucherRepository.findAllByEndDateGreaterThanAndQuantityGreaterThan(Calendar.getInstance().getTimeInMillis(), 0);
    }
}
