package com.thang.demo.controller.curd;

import com.thang.demo.entity.Category;
import com.thang.demo.entity.Form;
import com.thang.demo.repository.CategoryRepository;
import com.thang.demo.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categoryList")
    public String showColorList(Model model) {

        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("view", "../category/index.jsp");
        return "/admin/index";
    }

    @GetMapping("/addcatagory")
    public String showAddColorForm(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("view", "../category/add.jsp");
        return "/admin/index";
    }


    @PostMapping("/add")
    public String addColor(@ModelAttribute @Valid Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/category/add";
        }
        categoryService.saveCategory(category);
        return "redirect:/category/categoryList";
    }

    @GetMapping("/update/{id}")
    public String showUpdateColorForm(@PathVariable("id") String id, Category category, Model model) {
        category = categoryRepository.getOne(id);
        model.addAttribute("category", category);
        model.addAttribute("view", "../category/update.jsp");
        return "/admin/index";
    }

    @PostMapping("/update")
    public String updateColor(@ModelAttribute @Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/update";
        }
        categoryService.saveCategory(category);
        return "redirect:/category/catagoryList";
    }

    @GetMapping("/delete/{id}")
    public String deleteColor(@PathVariable("id") Category category) {
        categoryRepository.delete(category);
        return "redirect:/category/catagoryList";
    }
}
