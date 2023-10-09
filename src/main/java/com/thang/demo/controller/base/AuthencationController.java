package com.thang.demo.controller.base;

import com.thang.demo.request.UserRequest;
import com.thang.demo.response.RegisterResponse;
import com.thang.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author thangdt
 */
@Controller
@RequestMapping("")
public class AuthencationController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String sigIn(){
        return "user/login";
    }

    @GetMapping("/register")
    public String viewSigUp( Model model){
        model.addAttribute("request", new UserRequest() );
        return "user/register";
    }

    @PostMapping("/register")
    public String signUp(@Valid @ModelAttribute("request") UserRequest request, BindingResult result, Model model){
        if(result.hasErrors()){
            return "user/register";
        }
        RegisterResponse response = userService.create(request);
        if(response.getStatus() == 404){
            model.addAttribute("error", response);
            return "user/register";
        }
        return "redirect:/login";
    }

}
