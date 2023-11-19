package com.thang.demo.service;

import com.thang.demo.entity.Category;
import com.thang.demo.entity.Color;

import java.util.List;

/**
 * @author thangdt
 */
public interface CategoryService {

    List<Category> SimpleCategory();
    List<Category> getAllCategory();
    Category getCategoryById(String id);
    Category saveCategory(Category category);
    void deleteCategory(String id);
}
