package com.thang.demo.controller.admin;

import com.thang.demo.request.FindBillDateRequest;
import com.thang.demo.service.StatisticalService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author thangdt
 */
@Controller
@RequestMapping("/admin/statistical")
public class StatisticalController {

    @Autowired
    private StatisticalService saStatisticalService;

    @GetMapping("")
    public String statistical(FindBillDateRequest findBillDateRequest, Model model){
        model.addAttribute("products", saStatisticalService.getAllStatisticalBestSellingProduct());
        model.addAttribute("day", saStatisticalService.getAllStatisticalDay());
        model.addAttribute("month", saStatisticalService.getAllStatisticalMonth());
        model.addAttribute("product", saStatisticalService.getAllStatisticalProductDate(findBillDateRequest));
        model.addAttribute("bill", saStatisticalService.getAllStatisticalBillDate(findBillDateRequest));
        return "admin/statistical";
    }
}
