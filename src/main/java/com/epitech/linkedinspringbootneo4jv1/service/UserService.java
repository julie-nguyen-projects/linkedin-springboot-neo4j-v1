package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.City;
import com.epitech.linkedinspringbootneo4jv1.model.Experience;
import com.epitech.linkedinspringbootneo4jv1.model.User;
import com.epitech.linkedinspringbootneo4jv1.repository.CityRepository;
import com.epitech.linkedinspringbootneo4jv1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Service for User class
 */
@Service
public class UserService {

    /** Repository for User class */
    private UserRepository userRepository;

    /**
     * CONSTRUCTOR
     * @param userRepository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Get a user by id
     * @param id : id searched
     * @return : user found or null
     */
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseGet(null);
    }

    /**
     * Get all users
     * @return : all users
     */
    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }

    /**
     * Get users by city
     * @param cityName : name of the city
     * @return : users living in the city
     */
    public Collection<User> getAllByCity(String cityName) {
        return userRepository.getAllUsersByCity(cityName);
    }

    /**
     * Get all experiences linked to a user
     * @param id : id of the user
     * @return : experiences of the user
     */
    public Collection<Experience> getAllUserExperiences(Long id) {
        Collection<Experience> allExperiences = new ArrayList<>();
        allExperiences.addAll(userRepository.getAllUserStudyExperiences(id));
        allExperiences.addAll(userRepository.getAllUserWorkCompanyExperiences(id));
        allExperiences.addAll(userRepository.getAllUserWorkSchoolExperiences(id));
        return allExperiences;
    }

    /**
     * Get students by school
     * @param schoolName : name of the school
     * @return : students who study in that school
     */
    public Collection<User> getStudentsBySchoolName(String schoolName) {
        // TODO check if school exists
        return userRepository.getStudentsBySchoolName(schoolName);
    }

    /**
     * Get users by company
     * @param companyName : name of the company
     * @return : users who work in that company
     */
    public Collection<User> getUsersByCompanyName(String companyName) {
        // TODO check if company exists
        return userRepository.getUsersByCompanyName(companyName);
    }

    /**
     * Get employees by school
     * @param schoolName : name of the school
     * @return : users who work in that school
     */
    public Collection<User> getEmployeesBySchoolName(String schoolName) {
        // TODO check if school exists
        return userRepository.getEmployeesBySchoolName(schoolName);
    }

    /**
     * Create a user
     * @param user : user to create
     * @return user created
     */
    public User addUser(User user) {
        if (user.getId() != null) {
            System.out.println("Error: can not create user with existing id.");
            // TODO : exception
            return null;
        }
        User newUser = this.userRepository.save(user);
//        if (user.getCity() != null) {
//            this.relationshipService.livesIn(user.getId(), user.getCity());
//        }
        return newUser;
    }
}
