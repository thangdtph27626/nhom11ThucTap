package com.thang.demo.controller.clinet;

import com.thang.demo.request.CardDetailRequest;
import com.thang.demo.request.SanPhamRequest;
import com.thang.demo.response.ProductDetailResponse;
import com.thang.demo.response.SanPhamResponseCustom;
import com.thang.demo.service.ProductDetailService;
import com.thang.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author thangdt
 */

@Controller
@RequestMapping("/product-detail")
public class ProductdetailController {

    @Autowired
    private ProductDetailService productDetailService;

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public String findProduct(@PathVariable("id") String id, Model model) {
        SanPhamRequest request = new SanPhamRequest();
        model.addAttribute("listProduct", productService.findProduct(request));
        model.addAttribute("id", id);
        model.addAttribute("product", productDetailService.findProductDetailByIdProduct(id));
        return "user/detail-product";
    }
}
