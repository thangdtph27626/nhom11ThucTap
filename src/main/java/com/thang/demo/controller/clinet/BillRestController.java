package com.thang.demo.controller.clinet;

import com.thang.demo.service.CartDetailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author thangdt
 */
@Controller
@RequestMapping("/bill")
public class BillRestController {

    @Value("${user}")
    private String userId;

    @Autowired
    private CartDetailService cartDetailService;

    @GetMapping("/payment")
    public String getAllProductInCart(Model model){
        model.addAttribute("code", "HD"+ RandomStringUtils.randomNumeric(5));
        model.addAttribute("products", cartDetailService.findAllCartByIdUser(userId));
        return "user/PayMentCart";
    }

}
