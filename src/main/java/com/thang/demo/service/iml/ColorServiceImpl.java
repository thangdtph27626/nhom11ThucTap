package com.thang.demo.service.iml;

import com.thang.demo.entity.Color;
import com.thang.demo.repository.ColorRepository;
import com.thang.demo.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thangdt
 */
@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;


    @Override
    public List<Color> simpleColor() {
        return colorRepository.findAll();
    }
}
