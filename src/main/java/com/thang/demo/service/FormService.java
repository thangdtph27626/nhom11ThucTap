package com.thang.demo.service;

import com.thang.demo.entity.Color;
import com.thang.demo.entity.Form;

import java.util.List;

/**
 * @author thangdt
 */
public interface FormService {

    List<Form> SimpleForm();
    List<Color> simpleColor();
    List<Form> getAllForm();
    Form getFormById(String id);
    Form saveForm(Form form);
    void deleteForm(String id);
}
