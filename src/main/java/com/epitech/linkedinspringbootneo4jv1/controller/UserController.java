package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.City;
import com.epitech.linkedinspringbootneo4jv1.model.Experience;
import com.epitech.linkedinspringbootneo4jv1.model.User;
import com.epitech.linkedinspringbootneo4jv1.service.CityService;
import com.epitech.linkedinspringbootneo4jv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Controller for User class
 */
@RestController
@RequestMapping("/")
public class UserController {

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

    /**
     * Get all experiences linked to a user
     * @param id : id of the user
     * @return : experiences of the user
     */
    @GetMapping("/users/{id}/experiences")
    public Collection<Experience> getUserExperiences(@PathVariable Long id) {
        return userService.getAllUserExperiences(id);
    }

    /**
     * Create a user
     * @param user : user to create
     * @return user created
     */
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
