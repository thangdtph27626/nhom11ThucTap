package com.thang.demo.service.iml;

import com.thang.demo.entity.Voucher;
import com.thang.demo.infrastructure.constant.Status;
import com.thang.demo.repository.VoucherRepository;
import com.thang.demo.request.VoucherRequest;
import com.thang.demo.service.VoucherService;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Voucher> getAll() {

        return null;
    }

    @Override
    public Voucher cretaeVoucher(VoucherRequest request) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Voucher voucher = new Voucher();
        voucher.setCode("KM"+ RandomStringUtils.randomNumeric(5));
        voucher.setName(request.getName());
        voucher.setQuantity(request.getQuantity());
        voucher.setStatus(Status.DANG_SU_DUNG);
        voucher.setValue(new BigDecimal(request.getValue()));
        try {
            if (!request.getStartDate().isEmpty()) {
                voucher.setStartDate(simpleDateFormat.parse(request.getStartDate()).getTime());
            }
            if (!request.getEndDate().isEmpty()) {
                voucher.setEndDate(simpleDateFormat.parse(request.getEndDate()).getTime());
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return voucherRepository.save(voucher);
    }

    @Override
    public Voucher updateVoucher(String id, VoucherRequest request) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Optional<Voucher> voucher = voucherRepository.findById(id);
        voucher.get().setName(request.getName());
        voucher.get().setQuantity(request.getQuantity());
        voucher.get().setStatus(Status.DANG_SU_DUNG);
        voucher.get().setValue(new BigDecimal(request.getValue()));
        try {
            if (!request.getStartDate().isEmpty()) {
                voucher.get().setStartDate(simpleDateFormat.parse(request.getStartDate()).getTime());
            }
            if (!request.getEndDate().isEmpty()) {
                voucher.get().setEndDate(simpleDateFormat.parse(request.getEndDate()).getTime());
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return voucherRepository.save(voucher.get());
    }

    @Override
    public boolean changStatusVoucher(String id) {
        Optional<Voucher> voucher = voucherRepository.findById(id);
        if (!voucher.isPresent()){
            return false;
        }
        voucher.get().setStatus(Status.KHONG_SU_DUNG);
        voucherRepository.save(voucher.get());
        return true;
    }
}
