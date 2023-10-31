package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author thangdt
 */
public interface ImageRepository extends JpaRepository<Image, String> {
}
