package com.thang.demo.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author thangdt
 */
@Getter
@Setter
public class AddAddressRequest {

    private String line;

    private String district;

    private String province;

    private String ward;

    private Integer provinceId;

    private Integer toDistrictId;

    private String wardCode;
}
