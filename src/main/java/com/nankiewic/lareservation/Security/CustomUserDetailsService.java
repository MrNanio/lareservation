package com.nankiewic.lareservation.Security;

import com.nankiewic.lareservation.Entity.User;
import com.nankiewic.lareservation.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user= userService.findByEmail(username);
        return UserDetailsImpl.build(user);
    }
}