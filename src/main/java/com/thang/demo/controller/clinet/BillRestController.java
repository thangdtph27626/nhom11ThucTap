package com.thang.demo.controller.clinet;

import com.thang.demo.service.CartDetailService;
import com.thang.demo.service.PayMentService;
import com.thang.demo.service.VoucherService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private PayMentService payMentService;

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/payment")
    public String getAllProductInCart(@RequestParam(value = "code", defaultValue = "") String code, Model model){
        if(code.isEmpty()){
            model.addAttribute("code", "HD"+ RandomStringUtils.randomNumeric(5));
            model.addAttribute("totalPay", "");
        }else{
            model.addAttribute("code", code);
            model.addAttribute("totalPay", payMentService.findByCodeBill(code).getTotalMoney());
        }
        model.addAttribute("products", cartDetailService.findAllCartByIdUser(userId));
        model.addAttribute("vouchers", voucherService.findAllByEndDateIsLessThan());
        return "user/PayMentCart";
    }

}
