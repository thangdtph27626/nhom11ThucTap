package com.thang.demo.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author thangdt
 */
@Setter
@Getter
public class BillRequest {

    private long startTime;
    private String startTimeString = new String("");
    private long endTime;
    private String endTimeString = new String("");
    private String status ;
    private String key;
    private String type ;

}
