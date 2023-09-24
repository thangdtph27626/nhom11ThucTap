package com.thang.demo.service.iml;

import com.thang.demo.entity.Size;
import com.thang.demo.repository.SizeRepository;
import com.thang.demo.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
