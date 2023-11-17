package com.thang.demo.controller.clinet.rest;

import com.thang.demo.controller.base.BaseController;
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
public class AddressRestController extends BaseController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address create(@RequestBody AddAddressRequest request){
        return addressService.creat(session.getUserId(), request);
    }

    @GetMapping
    public List<Address> findByUser(){
        return addressService.findByUser(session.getUserId());
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") String id){
        return addressService.delete(id);
    }

}
