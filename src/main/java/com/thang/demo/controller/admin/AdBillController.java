package com.thang.demo.controller.admin;

import com.thang.demo.request.BillRequest;
import com.thang.demo.request.ChangStatusBillRequest;
import com.thang.demo.service.BillDetailService;
import com.thang.demo.service.BillHistoryService;
import com.thang.demo.service.BillService;
import com.thang.demo.service.PayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author thangdt
 */
@Controller
@RequestMapping("/admin/bill")
public class AdBillController {

    @Autowired
    private BillService billService;

    @Autowired
    private BillHistoryService billHistoryService;

    @Autowired
    private PayMentService payMentService;

    @Autowired
    private BillDetailService billDetailService;

    @GetMapping
    private String getAll(BillRequest request, Model model){
        model.addAttribute("bills", billService.getAll(request));
        return "admin/bill-manager";
    }

    @GetMapping("/{idBill}")
    private String getAll(@PathVariable("idBill") String idBill, Model model){
        model.addAttribute("bill", billService.findById(idBill));
        model.addAttribute("billHistorys", billHistoryService.findAllByBill(idBill));
        model.addAttribute("payment", payMentService.findByBill(idBill));
        model.addAttribute("billDetails", billDetailService.findAllByIdBill(idBill));
        return "admin/bill-detail";
    }

    @PostMapping("/change-status")
    private String changeStatus(ChangStatusBillRequest request){
        billService.changedStatusbill(request);
        return "redirect:/admin/bill/"+request.getId();
    }

    @PostMapping("/cancel-bill")
    private String cancelBill(ChangStatusBillRequest request){
        billService.cancelBill(request);
        return "redirect:/admin/bill/"+request.getId();
    }
}
