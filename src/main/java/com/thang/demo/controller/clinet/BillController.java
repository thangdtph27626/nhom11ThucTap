package com.thang.demo.controller.clinet;

import com.thang.demo.controller.base.BaseController;
import com.thang.demo.service.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author thangdt
 */
@Controller
@RequestMapping("/bill")
public class BillController extends BaseController {


    @Autowired
    private CartDetailService cartDetailService;

    @Autowired
    private PayMentService payMentService;

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private BillService billService;

    @Autowired
    private BillHistoryService billHistoryService;

    @Autowired
    private BillDetailService billDetailService;

    @GetMapping("/payment")
    public String getAllProductInCart(@RequestParam(value = "code", defaultValue = "") String code, Model model){
        if(code.isEmpty()){
            model.addAttribute("code", "HD"+ RandomStringUtils.randomNumeric(5));
            model.addAttribute("totalPay", "");
        }else{
            model.addAttribute("code", code);
            model.addAttribute("totalPay", payMentService.findByCodeBill(code).getTotalMoney());
        }
        model.addAttribute("products", cartDetailService.findAllCartByIdUser(session.getUserId()));
        model.addAttribute("vouchers", voucherService.findAllByEndDateIsLessThan());
        return "user/PayMentCart";
    }

    @GetMapping("/{idBill}")
    private String getAll(@PathVariable("idBill") String idBill, Model model){
        model.addAttribute("bill", billService.findById(idBill));
        model.addAttribute("billHistorys", billHistoryService.findAllByBill(idBill));
        model.addAttribute("payment", payMentService.findByBill(idBill));
        model.addAttribute("billDetails", billDetailService.findAllByIdBill(idBill));
        return "user/cl-bill-detail";
    }

}
