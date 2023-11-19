package com.thang.demo.service;

import com.thang.demo.entity.Form;
import com.thang.demo.entity.Product;
import com.thang.demo.request.SanPhamRequest;
import com.thang.demo.response.SanPhamResponseCustom;

import java.util.List;

/**
 * @author thangdt
 */
public interface ProductService {

    List<SanPhamResponseCustom> findProduct(SanPhamRequest request);
    List<Product> getAllProduct();
    Product getProductById(String id);
    Product saveProduct(Product product);
    void deleteProduct(String id);
}
