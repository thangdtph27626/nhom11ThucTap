package com.thang.demo.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author thangdt
 */
@Getter
@Setter
public class FindBillDateRequest {
    private Long startDate;

    private Long endDate;
}

