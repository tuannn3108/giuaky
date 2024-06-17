package com.example.truonganhtuan.services;

import com.example.truonganhtuan.entity.User;
import com.example.truonganhtuan.repository.IRoleRepository;
import com.example.truonganhtuan.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;


    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void someMethod(String username) {
        User user = userRepository.findByUserName(username);

    }
    public void save(User user){
        User existingUser = userRepository.findByUserName(user.getUsername());
        if(existingUser != null){
            return;

        }
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        if (userId != null) {
            Long roleId = roleRepository.getRoleIdByName("USER");
            if (roleId != 0) {
                userRepository.addRoleToUser(userId.longValue(), roleId);
            }
        }



    }









}
