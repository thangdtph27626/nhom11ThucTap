package com.thang.demo.service;

import com.thang.demo.entity.CartDetail;
import com.thang.demo.request.CardDetailRequest;
import com.thang.demo.request.UpdateQuantityInCartRequest;
import com.thang.demo.response.CartDetailResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author thangdt
 */
public interface CartDetailService {

    CartDetail save(String idUser, CardDetailRequest request);

    List<CartDetailResponse> findAllCartByIdUser( String idUser);

    CartDetail updateQuantity(UpdateQuantityInCartRequest request);

    boolean delete(String id);
}
