package com.thang.demo.infrastructure.common;

import com.thang.demo.infrastructure.constant.PaginationConstant;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class PageableRequest {

    private int page = PaginationConstant.DEFAULT_PAGE;
    private int size = PaginationConstant.DEFAULT_SIZE;
}
