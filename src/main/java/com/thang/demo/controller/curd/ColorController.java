package com.thang.demo.controller.curd;

import com.thang.demo.entity.Color;
import com.thang.demo.entity.Status;
import com.thang.demo.repository.ColorRepository;
import com.thang.demo.service.ColorService;
import com.thang.demo.service.iml.ColorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/color")
public class ColorController {


    @Autowired
    private ColorService colorService;
    @Autowired
    private ColorRepository clr;


    @GetMapping("/colorList")
    public String showColorList(Model model) {

        List<Color> colors = colorService.getAllColors();
        model.addAttribute("colors", colors);
//        return "/color/index";
        model.addAttribute("view", "../color/index.jsp");
        return "/admin/index";
    }

    @GetMapping("/addColor")
    public String showAddColorForm(Model model) {
        model.addAttribute("color", new Color());
//        return "/color/add";
        model.addAttribute("view", "../color/add.jsp");
        return "/admin/index";
    }


    @PostMapping("/add")
    public String addColor(@ModelAttribute @Valid Color color, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/color/add";
        }
        colorService.saveColor(color);
        return "redirect:/color/colorList";
    }

    @GetMapping("/update/{id}")
    public String showUpdateColorForm(@PathVariable("id") String id,Color color, Model model) {
       color = clr.getOne(id);
        model.addAttribute("color", color);
        model.addAttribute("view", "../color/update.jsp");
        return "/admin/index";
    }

    @PostMapping("/update")
    public String updateColor(@ModelAttribute @Valid Color color, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "color/update";
        }
        colorService.saveColor(color);
        return "redirect:/color/colorList";
    }

    @GetMapping("/delete/{id}")
    public String deleteColor(@PathVariable("id") Color color) {
        clr.delete(color);
        return "redirect:/color/colorList";
    }
}


