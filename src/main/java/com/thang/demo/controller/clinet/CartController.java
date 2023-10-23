package com.thang.demo.controller.clinet;

import com.thang.demo.controller.base.BaseController;
import com.thang.demo.request.CardDetailRequest;
import com.thang.demo.request.UpdateQuantityInCartRequest;
import com.thang.demo.service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author thangdt
 */
@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {

    @Autowired
    private CartDetailService cartDetailService;

    @PostMapping()
    public String save( CardDetailRequest request){
        cartDetailService.save(session.getUserId(), request);
        return "redirect:/product-detail/" + request.getIdProduct();
    }

    @PostMapping("/update-quantity")
    public String updateQuantity(UpdateQuantityInCartRequest request, Model model){
        cartDetailService.updateQuantity(request);
        model.addAttribute("products", cartDetailService.findAllCartByIdUser(session.getUserId()));
        return "redirect:user/cart-detail";
    }

    @GetMapping("/cart-detail")
    public String getAllProductInCart(Model model){
       model.addAttribute("products", cartDetailService.findAllCartByIdUser(session.getUserId()));
       return "user/cart-detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id")String id, Model model){
        cartDetailService.delete(id);
        model.addAttribute("products", cartDetailService.findAllCartByIdUser(session.getUserId()));
        return "redirect:user/cart-detail";
    }
}
