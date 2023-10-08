package com.thang.demo.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author thangdt
 */
@Controller
@RequestMapping("")
public class AuthencationController {

    @GetMapping("/login")
    public String sigIn(){
        return "user/login";
    }
}
