package com.thang.demo.service;

import com.thang.demo.entity.Form;
import com.thang.demo.entity.Size;

import java.util.List;

/**
 * @author thangdt
 */
public interface SizeService {

    List<Size> SimpleSize();
    List<Size> getAllSize();
    Size getSizeById(String id);
    Size saveSize(Size size);
    void deleteSize(String id);
}
