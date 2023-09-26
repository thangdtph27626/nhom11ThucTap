package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author thangdt
 */
public interface NotifycationRepository extends JpaRepository<Notification, String> {
}
