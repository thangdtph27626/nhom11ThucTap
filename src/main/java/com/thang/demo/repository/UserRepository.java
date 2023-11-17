package com.thang.demo.repository;

import com.thang.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author thangdt
 */
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

}
