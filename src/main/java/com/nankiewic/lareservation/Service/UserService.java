package com.nankiewic.lareservation.Service;

import com.nankiewic.lareservation.Entity.User;
import com.nankiewic.lareservation.Repository.RoleRepository;
import com.nankiewic.lareservation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    public void register(User user){
        user.setCreatedAt(LocalDateTime.now());
        user.setRoles(roleRepository.findRoleByRole("USER"));
        userRepository.save(user);
    }
    public void update(User user){
        userRepository.save(user);
    }
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}