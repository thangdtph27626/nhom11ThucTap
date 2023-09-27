package com.thang.demo.service.iml;

import com.thang.demo.entity.*;
import com.thang.demo.repository.*;
import com.thang.demo.request.CardDetailRequest;
import com.thang.demo.request.UpdateQuantityInCartRequest;
import com.thang.demo.response.CartDetailResponse;
import com.thang.demo.service.CartDetailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author thangdt
 */
@Service
@Transactional
public class CartDetailServiceImpl implements CartDetailService {

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public CartDetail save(String idUser, CardDetailRequest request) {
        Optional<Size> size  = sizeRepository.findById(request.getIdSize());
        Optional<Color> color = colorRepository.findById(request.getIdColor());
        Optional<Product> product = productRepository.findById(request.getIdProduct());
        ProductDetail productDetail = productDetailRepository.findBySizeAndColorAndProduct(size.get(), color.get(),product.get());
        Optional<User> user = userRepository.findById(idUser);
        Cart cart = cartRepository.findByUser(user.get());
        Optional<CartDetail> cartDetailOptional = cartDetailRepository.findByProductDetail(productDetail);
        if(cartDetailOptional.isPresent()){
            cartDetailOptional.get().setQuantity(cartDetailOptional.get().getQuantity() + request.getQuantity());
            return cartDetailRepository.save(cartDetailOptional.get());
        }
        CartDetail cartDetail = CartDetail.builder().cart(cart).productDetail(productDetail).quantity(request.getQuantity()).price(productDetail.getPrice()).build();
        return cartDetailRepository.save(cartDetail);
    }

    @Override
    public List<CartDetailResponse> findAllCartByIdUser(String idUser) {
        return cartDetailRepository.findAllCartByIdUser(idUser);
    }

    @Override
    public CartDetail updateQuantity(UpdateQuantityInCartRequest request) {
        Optional<CartDetail> cartDetail = cartDetailRepository.findById(request.getId());
        cartDetail.get().setQuantity(request.getQuantity());
        return cartDetailRepository.save(cartDetail.get());
    }

    @Override
    public boolean delete(String id) {
        cartDetailRepository.deleteById(id);
        return true;
    }
}
