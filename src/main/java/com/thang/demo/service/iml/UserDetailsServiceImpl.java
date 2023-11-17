package com.thang.demo.service.iml;

import com.thang.demo.config.UserDetailCustom;
import com.thang.demo.entity.User;
import com.thang.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author thangdt
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
//        if(user.isPresent()){
//            throw  new RuntimeException("user not exit");
//        }
        System.out.println(user.get().toString());
        return new UserDetailCustom(user.get());
    }
}
