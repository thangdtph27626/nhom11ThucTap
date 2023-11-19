package com.thang.demo.controller.curd;

import com.thang.demo.entity.Color;
import com.thang.demo.entity.Form;
import com.thang.demo.entity.Size;
import com.thang.demo.repository.ColorRepository;
import com.thang.demo.repository.FormRepository;
import com.thang.demo.repository.SizeRepository;
import com.thang.demo.service.FormService;
import com.thang.demo.service.SizeService;
import com.thang.demo.service.iml.ColorServiceImpl;
import com.thang.demo.service.iml.SizeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/size")
public class SizeController {

    @Autowired
    private SizeService sizeService;
    @Autowired
    private SizeRepository sr;


    @GetMapping("/sizeList")
    public String showColorList(Model model) {

        List<Size> sizes = sizeService.getAllSize();
        model.addAttribute("sizes", sizes);
        model.addAttribute("view", "../size/index.jsp");
        return "/admin/index";
    }

    @GetMapping("/addSize")
    public String showAddColorForm(Model model) {
        model.addAttribute("size", new Size());
        model.addAttribute("view", "../size/add.jsp");
        return "/admin/index";
    }


    @PostMapping("/add")
    public String addColor(@ModelAttribute @Valid Size size, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/size/add";
        }
        sizeService.saveSize(size);
        return "redirect:/size/sizeList";
    }

    @GetMapping("/update/{id}")
    public String showUpdateColorForm(@PathVariable("id") String id,Size size, Model model) {
        size = sizeService.getSizeById(id);
        model.addAttribute("size", size);
        model.addAttribute("view", "../size/update.jsp");
        return "/admin/index";
    }

    @PostMapping("/update")
    public String updateColor(@ModelAttribute @Valid Size size, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "size/update";
        }
        sizeService.saveSize(size);
        return "redirect:/size/sizeList";
    }

    @GetMapping("/delete/{id}")
    public String deleteColor(@PathVariable("id") Size size) {
        sr.delete(size);
        return "redirect:/size/sizeList";
    }
}
