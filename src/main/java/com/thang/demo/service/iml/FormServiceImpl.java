package com.thang.demo.service.iml;

import com.thang.demo.entity.Color;
import com.thang.demo.entity.Form;
import com.thang.demo.infrastructure.constant.Status;
import com.thang.demo.repository.FormRepository;
import com.thang.demo.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<Color> simpleColor() {
        return null;
    }

    @Override
    public List<Form> getAllForm() {
        return formRepository.findAll();
    }

    @Override
    public Form getFormById(String id) {
        return formRepository.findById(id).orElse(null);
    }

    @Override
    public Form saveForm(Form form) {
        form.setId(null);
        form.setStatus(Status.DANG_SU_DUNG);
        return formRepository.save(form);
    }

    @Override
    public void deleteForm(String id) {
     formRepository.deleteById(id);
    }

    public Page<Form> search(String key, Pageable pageable){
        if(key != null){
            return formRepository.search(key,pageable);
        }
        return formRepository.findAll(pageable);
    }
}
