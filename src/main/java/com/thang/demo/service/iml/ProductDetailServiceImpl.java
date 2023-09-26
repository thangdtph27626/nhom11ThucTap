package com.thang.demo.service.iml;

import com.thang.demo.repository.ProductDetailRepository;
import com.thang.demo.repository.ProductRepository;
import com.thang.demo.response.*;
import com.thang.demo.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author thangdt
 */

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public ProductDetailConverResponse findProductDetailByIdProduct(String idPrduct) {
        ProductDetailConverResponse response = new ProductDetailConverResponse();
        List<PriceProductRespone> prices = new ArrayList<>();
        Map<String, SimpleResponse> colors = new HashMap<>();
        Map<String, SimpleResponse> sizes = new HashMap<>();
        List<QuantityProductResponse> quantitys = new ArrayList<>();
        productDetailRepository.findProductDetailByIdProduct(idPrduct).forEach(item -> {
            response.setName(item.getName());
            response.setId(item.getId());
            response.setGender(item.getGender());
            response.setCategory(item.getCategory());
            response.setForm(item.getForm());
            prices.add(new PriceProductRespone(item.getPrice(), item.getIdSize(), item.getIdColor()));
            colors.put(item.getIdColor(), new SimpleResponse(item.getIdColor(), item.getColor()));
            sizes.put(item.getIdColor(), new SimpleResponse(item.getIdSize(), item.getSize()));
            quantitys.add(new QuantityProductResponse(item.getQuantity(), item.getIdSize(), item.getIdColor()));
        });
        response.setColors( colors.values().stream().toList());
        response.setPrices(prices);
        response.setSizes(sizes.values().stream().toList());
        response.setQuantitys(quantitys);
        return response;
    }
}
