package com.thang.demo.service;

import com.thang.demo.response.ProductDetailConverResponse;
import com.thang.demo.response.ProductDetailResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author thangdt
 */
public interface ProductDetailService {

    ProductDetailConverResponse findProductDetailByIdProduct(String idPrduct);
}
