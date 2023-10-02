package com.thang.demo.controller.clinet.rest;

import com.thang.demo.entity.Address;
import com.thang.demo.request.AddAddressRequest;
import com.thang.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author thangdt
 */
@RestController
@RequestMapping("/address")
public class AddressRestController {

    @Value("${user}")
    private String userId;

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address create(@RequestBody AddAddressRequest request){
        return addressService.creat(userId, request);
    }

    @GetMapping
    public List<Address> findByUser(){
        return addressService.findByUser(userId);
    }

}
