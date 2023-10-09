package com.thang.demo.service;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.User;
import com.thang.demo.request.AddAddressRequest;

import java.util.List;

/**
 * @author thangdt
 */
public interface AddressService {

    List<Address> findByUser(String idUser);

    Address creat(String idUser, AddAddressRequest request);

    boolean delete(String id);
}
