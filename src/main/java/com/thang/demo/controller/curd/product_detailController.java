package com.thang.demo.controller.curd;

import com.thang.demo.entity.*;
import com.thang.demo.infrastructure.constant.GenderProductDetail;
import com.thang.demo.infrastructure.constant.Status;
import com.thang.demo.repository.*;
import com.thang.demo.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product-detail")
public class product_detailController {
    @Autowired
    ProductRepository pr;
    @Autowired
    ProductDetailService pds;
    @Autowired
    ProductDetailRepository pdr;
    @Autowired
    CategoryRepository cr;
    @Autowired
    ColorRepository clr;
    @Autowired
    FormRepository fr;
    @Autowired
    SizeRepository sz;
//    @Autowired
//    ImageService imageService;

    @GetMapping("/hien-thi")
    public String hien(Model model) {
        List<ProductDetail> list = pdr.findAll();
        model.addAttribute("product", pr.findAll());
        model.addAttribute("category", cr.findAll());
        model.addAttribute("color", clr.findAll());
        model.addAttribute("size", sz.findAll());
        model.addAttribute("form", fr.findAll());
        model.addAttribute("product_details", list);
        return "/product_detail/index";
    }

    @GetMapping("/view-add")
    public String view_add(Model model, @ModelAttribute("VM") Product_Detail productDetail) {
        model.addAttribute("product", pr.findAll());
        model.addAttribute("category", cr.findAll());
        model.addAttribute("color", clr.findAll());
        model.addAttribute("size", sz.findAll());
        model.addAttribute("form", fr.findAll());
        model.addAttribute("product_detali", productDetail);
        return "/product_detail/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("VM") Product_Detail vm) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setDescription(vm.getDescription());
        productDetail.setPrice(vm.getPrice());
        productDetail.setQuantity(vm.getQuantity());
        productDetail.setStatus(Status.DANG_SU_DUNG);
        productDetail.setGender(GenderProductDetail.NAM_VA_NU);
        Product pd = this.pr.findById(vm.getIdProduct()).get();
        productDetail.setProduct(pd);
        Category ct = this.cr.findById(vm.getIdCategory()).get();
        Color cl = this.clr.findById(vm.getIdColor()).get();
        Size sz = this.sz.findById(vm.getIdSize()).get();
        Form fr = this.fr.findById(vm.getIdForm()).get();
        productDetail.setCategory(ct);
        productDetail.setColor(cl);
        productDetail.setSize(sz);
        productDetail.setForm(fr);
        this.pdr.save(productDetail);
        return "redirect:/product-detail/hien-thi";
    }

    @GetMapping("/update/{id}")
    public String vu(@PathVariable("id") String id, Model model, @ModelAttribute("VM") Product_Detail productDetail) {
        model.addAttribute("product", pr.findAll());
        model.addAttribute("category", cr.findAll());
        model.addAttribute("color", clr.findAll());
        model.addAttribute("size", sz.findAll());
        model.addAttribute("form", fr.findAll());
        ProductDetail pr = pds.getProductDetailById(id);
        model.addAttribute("product_detali", pr);
        return "/product_detail/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("VM") Product_Detail vm) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setDescription(vm.getDescription());
        productDetail.setPrice(vm.getPrice());
        productDetail.setQuantity(vm.getQuantity());
        productDetail.setStatus(Status.DANG_SU_DUNG);
        productDetail.setGender(GenderProductDetail.NAM_VA_NU);
        Product pd = this.pr.findById(vm.getIdProduct()).get();
        productDetail.setProduct(pd);
        Category ct = this.cr.findById(vm.getIdCategory()).get();
        Color cl = this.clr.findById(vm.getIdColor()).get();
        Size sz = this.sz.findById(vm.getIdSize()).get();
        Form fr = this.fr.findById(vm.getIdForm()).get();
        productDetail.setCategory(ct);
        productDetail.setColor(cl);
        productDetail.setSize(sz);
        productDetail.setForm(fr);
        this.pdr.save(productDetail);
        return "redirect:/product-detail/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String deleteColor(@PathVariable("id") ProductDetail productDetail) {
        pdr.delete(productDetail);
        return "redirect:/product-detail/hien-thi";
    }

    @GetMapping("/upload/{id}")
    public String upload(@PathVariable("id") String id, Model model) {
        model.addAttribute("productId", id);
        return "/image/hien_thi";
    }

//    @PostMapping("/yourMapping/{id}/uploadImage")
//    public String handleFileUpload(
//            @PathVariable String productId,
//            @RequestParam("file") MultipartFile file,
//            @RequestParam("name") String name,
//            @RequestParam("status") Boolean status
//    ) {
//        // Thực hiện xử lý upload ảnh và lưu đường dẫn vào cơ sở dữ liệu
//        ImageService imageService = new ImageService();
//        imageService.uploadImage(productId,file,name,status);
//
//        // Chuyển hướng hoặc trả về trang kết quả
//        return "redirect:/yourMapping/{productId}";
//    }
}