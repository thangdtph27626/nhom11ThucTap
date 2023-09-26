package com.thang.demo.service;

import com.thang.demo.entity.CartDetail;
import com.thang.demo.request.CardDetailRequest;

/**
 * @author thangdt
 */
public interface CartDetailService {

    CartDetail save(String idUser, CardDetailRequest request);
}
