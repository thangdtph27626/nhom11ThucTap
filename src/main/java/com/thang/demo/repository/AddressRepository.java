package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author thangdt
 */
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
