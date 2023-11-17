package com.thang.demo.config;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author thangdt
 */
@Component
public class SessionImpl implements Session{

    @Autowired
    private HttpSession session;


    @Override
    public String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailCustom userDetailCustom = (UserDetailCustom)  authentication.getPrincipal();
        return userDetailCustom.getUser().getId();
    }
}
