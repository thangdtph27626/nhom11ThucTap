package com.thang.demo.service.iml;

import com.thang.demo.entity.Color;
import com.thang.demo.infrastructure.constant.Status;
import com.thang.demo.repository.ColorRepository;
import com.thang.demo.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public Color getColorById(String id) {
        return colorRepository.findById(id).orElse(null);
    }

    @Override
    public Color saveColor(Color color) {
        // Đảm bảo rằng ID không được chỉ định trước khi lưu vào cơ sở dữ liệu
        color.setId(null);
        color.setStatus(Status.DANG_SU_DUNG);
        return colorRepository.save(color);
    }

    @Override
    public void deleteColor(String id) {
        colorRepository.deleteById(id);
    }
    @Override
    public List<Color> simpleColor() {
        return colorRepository.findAll();
    }
//    @Autowired
//    MauSacReponsitories msr;
    public Page<Color> search(String key, Pageable pageable){
        if(key != null){
            return colorRepository.search(key,pageable);
        }
        return colorRepository.findAll(pageable);
    }
}
