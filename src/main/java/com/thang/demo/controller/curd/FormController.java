package com.thang.demo.controller.curd;

import com.thang.demo.entity.Color;
import com.thang.demo.entity.Form;
import com.thang.demo.repository.ColorRepository;
import com.thang.demo.repository.FormRepository;
import com.thang.demo.service.ColorService;
import com.thang.demo.service.FormService;
import com.thang.demo.service.iml.FormServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/form")
public class FormController {


    @Autowired
    private FormService formService;
    @Autowired
    private FormRepository fr;


    @GetMapping("/formList")
    public String showColorList(Model model) {

        List<Form> forms = formService.getAllForm();
        model.addAttribute("forms", forms);

        model.addAttribute("view", "../form/index.jsp");
        return "/admin/index";
    }

    @GetMapping("/addForm")
    public String showAddColorForm(Model model) {
        model.addAttribute("form", new Form());
        model.addAttribute("view", "../form/add.jsp");
        return "/admin/index";
    }


    @PostMapping("/add")
    public String addColor(@ModelAttribute @Valid Form form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/form/add";
        }
        formService.saveForm(form);
        return "redirect:/form/formList";
    }

    @GetMapping("/update/{id}")
    public String showUpdateColorForm(@PathVariable("id") String id,Form form, Model model) {
        form = fr.getOne(id);
        model.addAttribute("form", form);
        model.addAttribute("view", "../form/update.jsp");
        return "/admin/index";
    }

    @PostMapping("/update")
    public String updateColor(@ModelAttribute @Valid Form form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form/update";
        }
        formService.saveForm(form);
        return "redirect:/form/formList";
    }

    @GetMapping("/delete/{id}")
    public String deleteColor(@PathVariable("id") Form form) {
        fr.delete(form);
        return "redirect:/form/formList";
    }
}
