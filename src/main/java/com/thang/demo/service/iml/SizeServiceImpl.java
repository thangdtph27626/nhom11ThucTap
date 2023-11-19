package com.thang.demo.service.iml;

import com.thang.demo.entity.Color;
import com.thang.demo.entity.Size;
import com.thang.demo.infrastructure.constant.Status;
import com.thang.demo.repository.SizeRepository;
import com.thang.demo.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thangdt
 */
@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;


    @Override
    public List<Size> SimpleSize() {
        return sizeRepository.findAll();
    }

    @Override
    public List<Size> getAllSize() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getSizeById(String id) {
        return sizeRepository.findById(id).orElse(null);
    }

    @Override
    public Size saveSize(Size size) {
        size.setId(null);
        size.setStatus(Status.DANG_SU_DUNG);
        return sizeRepository.save(size);
    }

    @Override
    public void deleteSize(String id) {
        sizeRepository.deleteById(id);
    }

    public Page<Size> search(String key, Pageable pageable) {
        if (key != null) {
            return sizeRepository.search(key, pageable);
        }
        return sizeRepository.findAll(pageable);
    }
}
