package com.thang.demo.service.iml;

import com.thang.demo.repository.ProductDetailRepository;
import com.thang.demo.repository.ProductRepository;
import com.thang.demo.response.*;
import com.thang.demo.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<SimpleResponse> colors = new ArrayList<>();
        List<SimpleResponse> sizes = new ArrayList<>();
        List<QuantityProductResponse> quantitys = new ArrayList<>();
        productDetailRepository.findProductDetailByIdProduct(idPrduct).forEach(item -> {
            response.setName(item.getName());
            response.setId(item.getId());
            response.setGender(item.getGender());
            response.setCategory(item.getCategory());
            response.setForm(item.getForm());
            prices.add(new PriceProductRespone(item.getPrice(), item.getIdSize(), item.getIdColor()));
            colors.add(new SimpleResponse(item.getIdColor(), item.getColor()));
            sizes.add(new SimpleResponse(item.getIdSize(), item.getSize()));
            quantitys.add(new QuantityProductResponse(item.getQuantity(), item.getIdSize(), item.getIdColor()));
        });
        response.setColors(colors);
        response.setPrices(prices);
        response.setSizes(sizes);
        response.setQuantitys(quantitys);
        return response;
    }
}
