package com.thang.demo.controller.curd;

import com.thang.demo.entity.Form;
import com.thang.demo.entity.Product;
import com.thang.demo.repository.FormRepository;
import com.thang.demo.repository.ProductRepository;
import com.thang.demo.service.FormService;
import com.thang.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class productController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository pr;


    @GetMapping("/productList")
    public String showColorList(Model model) {

        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("view", "../product/index.jsp");
        return "/admin/index";
    }

    @GetMapping("/addproduct")
    public String showAddColorForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("view", "../product/add.jsp");
        return "/admin/index";
    }


    @PostMapping("/add")
    public String addColor(@ModelAttribute @Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/product/add";
        }
        productService.saveProduct(product);
        return "redirect:/product/productList";
    }

    @GetMapping("/update/{id}")
    public String showUpdateColorForm(@PathVariable("id") String id, Product product, Model model) {
        product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("view", "../product/update.jsp");
        return "/admin/index";
    }

    @PostMapping("/update")
    public String updateColor(@ModelAttribute @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product/update";
        }
        productService.saveProduct(product);
        return "redirect:/product/productList";
    }

    @GetMapping("/delete/{id}")
    public String deleteColor(@PathVariable("id") Product product) {
        pr.delete(product);
        return "redirect:/product/productList";
    }
}
