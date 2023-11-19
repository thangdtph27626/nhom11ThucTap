package com.thang.demo.service;

import com.thang.demo.entity.Form;
import com.thang.demo.entity.ProductDetail;
import com.thang.demo.response.ProductDetailConverResponse;
import com.thang.demo.response.ProductDetailResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author thangdt
 */
public interface ProductDetailService {

    ProductDetailConverResponse findProductDetailByIdProduct(String idPrduct);
    List<ProductDetail> getAllProductDetail();
    ProductDetail getProductDetailById(String id);
    ProductDetail saveProductDetail(ProductDetail ProductDetail);
    void deleteProductDetail(String id);
}
