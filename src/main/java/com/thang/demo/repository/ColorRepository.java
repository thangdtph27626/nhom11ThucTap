package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author thangdt
 */
public interface ColorRepository extends JpaRepository<Color, String> {
}
