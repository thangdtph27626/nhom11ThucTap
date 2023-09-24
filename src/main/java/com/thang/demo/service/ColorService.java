package com.thang.demo.service;

import com.thang.demo.entity.Color;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author thangdt
 */
public interface ColorService {

     List<Color> simpleColor();
}
