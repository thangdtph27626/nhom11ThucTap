package com.thang.demo.service.iml;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.User;
import com.thang.demo.infrastructure.constant.Status;
import com.thang.demo.repository.AddressRepository;
import com.thang.demo.repository.UserRepository;
import com.thang.demo.request.AddAddressRequest;
import com.thang.demo.service.AddressService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author thangdt
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Address> findByUser(String idUser) {
        Optional<User> user = userRepository.findById(idUser);
        return addressRepository.findByUser(user.get());
    }

    @Override
    public Address creat(String idUser, AddAddressRequest request) {
        Optional<User> user = userRepository.findById(idUser);
        Address address = Address.builder().line(request.getLine()).district(request.getDistrict()).province(request.getProvince()).ward(request.getWard()).user(user.get()).provinceId(request.getProvinceId()).toDistrictId(request.getToDistrictId()).wardCode(request.getWardCode()).status(Status.DANG_SU_DUNG).build();
        return addressRepository.save(address);
    }

    @Override
    public boolean delete(String id) {
        addressRepository.deleteById(id);
        return true;
    }
}
