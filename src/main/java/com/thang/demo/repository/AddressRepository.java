package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author thangdt
 */
public interface AddressRepository extends JpaRepository<Address, String> {

    List<Address> findByUser(User user);

}
