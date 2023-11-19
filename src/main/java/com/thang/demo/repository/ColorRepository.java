package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 * @author thangdt
 */
public interface ColorRepository extends JpaRepository<Color, String> {
    @Query("SELECT ms FROM Color ms where ms.name LIKE %?1% or ms.code like %?1%")
    Page<Color> search(String key, Pageable pageable);

    Page<Color> findAll(Pageable pageable );
}
