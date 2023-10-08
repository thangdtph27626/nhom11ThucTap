package com.thang.demo.controller.clinet;

import com.thang.demo.controller.base.BaseController;
import com.thang.demo.entity.Size;
import com.thang.demo.request.SanPhamRequest;
import com.thang.demo.response.SanPhamResponseCustom;
import com.thang.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author thangdt
 */
@Controller
@RequestMapping("/home")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private FormService formService;

    @Autowired
    private SizeService sizeService;


    @GetMapping("")
    public String findProduct(Model model){
        System.out.println(session.getUserId());
        SanPhamRequest request = new SanPhamRequest();
        model.addAttribute("listProduct", productService.findProduct(request));
        return "user/index";
    }

    @GetMapping("/search")
    public String search(SanPhamRequest request, Model model){
        model.addAttribute("listProduct", productService.findProduct(request));
        model.addAttribute("categorys", categoryService.SimpleCategory());
        model.addAttribute("colors", colorService.simpleColor());
        model.addAttribute("forms", formService.SimpleForm());
        model.addAttribute("sizes", sizeService.SimpleSize());
        return "user/viewSearch";
    }
}
