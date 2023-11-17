package com.thang.demo.controller.base;

import com.thang.demo.config.Session;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author thangdt
 */
public abstract class BaseController {

    @Autowired
    protected Session session;

}