package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Cart;
import com.thang.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author thangdt
 */
public interface CartRepository extends JpaRepository<Cart, String> {

    Cart findByUser(User user);

}
