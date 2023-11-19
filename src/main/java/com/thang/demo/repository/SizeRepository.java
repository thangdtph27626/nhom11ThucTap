package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Color;
import com.thang.demo.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 * @author thangdt
 */
public interface SizeRepository extends JpaRepository<Size, String> {
    @Query("SELECT sz FROM Size sz where sz.name = ?1 or sz.id like %?1%")
    Page<Size> search(String key, Pageable pageable);

    Page<Size> findAll(Pageable pageable );
}
