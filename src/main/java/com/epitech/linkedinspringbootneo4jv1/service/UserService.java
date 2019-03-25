package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.Experience;
import com.epitech.linkedinspringbootneo4jv1.model.User;
import com.epitech.linkedinspringbootneo4jv1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Service for User class
 */
@Service
public class UserService {

    /** Repository for User class */
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Get a user by id
     * @param id : id searched
     * @return : user found
     */
    public User findById(Long id) {
        User result = this.userRepository.findById(id).orElseGet(null);
        return result;
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
}
