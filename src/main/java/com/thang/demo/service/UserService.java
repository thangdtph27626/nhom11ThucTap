package com.thang.demo.service;

import com.thang.demo.entity.User;
import com.thang.demo.request.UserRequest;
import com.thang.demo.response.RegisterResponse;

/**
 * @author thangdt
 */
public interface UserService {

    User findById(String id);

    RegisterResponse create(UserRequest request);
}
