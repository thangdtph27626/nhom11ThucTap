package com.thang.demo.response;

import com.thang.demo.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface imageRepository extends JpaRepository<Image,String> {

}
