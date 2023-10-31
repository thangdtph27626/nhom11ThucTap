package com.thang.demo.controller.admin;

import com.thang.demo.request.FindBillDateRequest;
import com.thang.demo.response.StatisticalProductDateResponse;
import com.thang.demo.response.StatisticalStatusBillResponse;
import com.thang.demo.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author thangdt
 */
@RestController
@RequestMapping("/admin/api/statistical")
public class StatisticalRestController {

    @Autowired
    private StatisticalService saStatisticalService;

    @GetMapping
    public List<StatisticalStatusBillResponse> getAllStatisticalStatusBill(){
        return saStatisticalService.getAllStatisticalStatusBill();
    }

    @GetMapping("/product")
    public List<StatisticalProductDateResponse> getAllStatisticalProductDate( FindBillDateRequest findBillDateRequest){
        return saStatisticalService.getAllStatisticalProductDate(findBillDateRequest);
    }
}
