package com.thang.demo.service.iml;

import com.thang.demo.entity.Cart;
import com.thang.demo.entity.User;
import com.thang.demo.infrastructure.constant.Roles;
import com.thang.demo.repository.CartRepository;
import com.thang.demo.repository.UserRepository;
import com.thang.demo.request.UserRequest;
import com.thang.demo.response.RegisterResponse;
import com.thang.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author thangdt
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public RegisterResponse create(UserRequest request) {
        Optional<User> optional = userRepository.findByEmail(request.getGmail());
        if(optional.isPresent()){
            return new RegisterResponse("Email already exists", 404);
        }
        User user = User.builder().roles(Roles.USER).email(request.getGmail()).fullName(request.getFullName()).password(new BCryptPasswordEncoder().encode(request.getPass())).build();
        userRepository.save(user);
        Cart cart = Cart.builder().user(user).build();
        cartRepository.save(cart);
        return new RegisterResponse("Success", 200);
    }
}
