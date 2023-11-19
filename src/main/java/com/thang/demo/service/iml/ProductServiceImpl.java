package com.thang.demo.service.iml;

import com.thang.demo.entity.Product;
import com.thang.demo.infrastructure.constant.Status;
import com.thang.demo.repository.ProductRepository;
import com.thang.demo.request.SanPhamRequest;
import com.thang.demo.response.SanPhamResponseCustom;
import com.thang.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thangdt
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<SanPhamResponseCustom> findProduct(SanPhamRequest request) {
        return productRepository.findProduct(request);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        product.setId(null);
        product.setStatus(Status.DANG_SU_DUNG);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
