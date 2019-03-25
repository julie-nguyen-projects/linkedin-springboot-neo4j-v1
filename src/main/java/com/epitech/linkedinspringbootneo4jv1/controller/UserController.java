package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.User;
import com.epitech.linkedinspringbootneo4jv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Controller for User class
 */
@RestController
@RequestMapping("/")
public class UserController {

    /** Bean of userService */
    @Autowired
    UserService userService;

    /**
     * Get a user by id
     * @param id : id searched
     * @return : user found
     */
    @GetMapping("/users/id/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    /**
     * Get all users
     * @return : all users
     */
    @GetMapping("/users")
    public Collection<User> getAll() {
        return userService.getAll();
    }

    /**
     * Get users by city
     * @param cityName : name of the city
     * @return : users living in the city
     */
    @GetMapping("/users/city/{cityName}")
    public Collection<User> getAllUsersByCity(@PathVariable String cityName) {
        return userService.getAllByCity(cityName);
    }
}
