package com.thang.demo.service.iml;

import com.thang.demo.entity.Category;
import com.thang.demo.repository.CategoryRepository;
import com.thang.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thangdt
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> SimpleCategory() {
        return categoryRepository.findAll();
    }
}
