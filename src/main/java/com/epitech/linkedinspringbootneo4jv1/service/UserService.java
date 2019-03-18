package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.User;
import com.epitech.linkedinspringbootneo4jv1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findById(Long id) {
        User result = this.userRepository.findById(id).orElseGet(null);
        return result;
    }

    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }
}
