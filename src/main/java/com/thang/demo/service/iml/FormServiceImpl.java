package com.thang.demo.service.iml;

import com.thang.demo.entity.Form;
import com.thang.demo.repository.FormRepository;
import com.thang.demo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thangdt
 */

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;

    @Override
    public List<Form> SimpleForm() {
        return formRepository.findAll();
    }
}
