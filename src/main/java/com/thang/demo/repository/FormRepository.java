package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author thangdt
 */
public interface FormRepository extends JpaRepository<Form, String> {
}
