package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.City;
import com.epitech.linkedinspringbootneo4jv1.model.Experience;
import com.epitech.linkedinspringbootneo4jv1.model.User;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
import com.epitech.linkedinspringbootneo4jv1.service.CityService;
import com.epitech.linkedinspringbootneo4jv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Controller for User class
 */
@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

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
     * Get posts by user
     * @param userId : id of the post
     * @return : post of the user
     */
    @GetMapping("/users/{userId}/posts")
    public Collection<Post> getAllUserPost(@PathVariable Long userId) {
        return userService.getAllUserPost(userId);
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
     * Get students by school
     * @param schoolName : name of the school
     * @return : ResponseEntity : status OK and students who study in that school in the body
     */
    @GetMapping("/users/school/students/{schoolName}")
    public ResponseEntity<Collection<User>> getStudentsBySchool(@PathVariable String schoolName) {
        return ResponseEntity.ok().body(userService.getStudentsBySchoolName(schoolName));
    }

    /**
     * Get employees by school
     * @param schoolName : name of the school
     * @return : ResponseEntity : status OK and users who work in that school in the body
     */
    @GetMapping("/users/school/employees/{schoolName}")
    public ResponseEntity<Collection<User>> getEmployeesBySchool(@PathVariable String schoolName) {
        return ResponseEntity.ok().body(userService.getEmployeesBySchoolName(schoolName));
    }

    /**
     * Get users by company
     * @param companyName : name of the company
     * @return : ResponseEntity : status OK and users who work in that company in the body
     */
    @GetMapping("users/company/{companyName}")
    public ResponseEntity<Collection<User>> getUsersByCompany(@PathVariable String companyName) {
        return ResponseEntity.ok().body(userService.getUsersByCompanyName(companyName));
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
