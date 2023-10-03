package com.thang.demo.response;

import com.thang.demo.entity.Bill;
import com.thang.demo.entity.BillDetail;
import com.thang.demo.entity.PaymentsMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author thangdt
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomBillByUserResponse {

    private Bill bill;

    private PaymentsMethod paymentsMethod;

    private List<BillDetail> billDetails;


}
