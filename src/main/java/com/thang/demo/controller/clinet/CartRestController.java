package com.thang.demo.controller.clinet;

import com.thang.demo.request.CardDetailRequest;
import com.thang.demo.service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author thangdt
 */
@Controller
@RequestMapping("/cart")
public class CartRestController {

    @Autowired
    private CartDetailService cartDetailService;

    @Value("${user}")
    private String userId;

    @PostMapping()
    public String save( CardDetailRequest request){
        cartDetailService.save(userId, request);
        return "redirect:/product-detail/" + request.getIdProduct();
    }
}
