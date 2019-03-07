package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.User;
import com.epitech.linkedinspringbootneo4jv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Collection<User> getAll() {
        return userService.getAll();
    }
}
