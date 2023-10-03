package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Bill;
import com.thang.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author thangdt
 */
public interface BillRepository extends JpaRepository<Bill, String> {

    Optional<Bill> findByCode(String code);

    List<Bill> findAllByUser(User user);
}
