package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Form;
import com.thang.demo.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 * @author thangdt
 */
public interface FormRepository extends JpaRepository<Form, String> {
    @Query("SELECT fr FROM Form fr where fr.name" +
            " = ?1 or fr.status = ?1")
    Page<Form> search(String key, Pageable pageable);

    Page<Form> findAll(Pageable pageable );
}
