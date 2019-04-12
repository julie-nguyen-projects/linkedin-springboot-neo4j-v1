package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.Experience;
import com.epitech.linkedinspringbootneo4jv1.model.User;
import com.epitech.linkedinspringbootneo4jv1.model.Post;
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

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Get a user by id
     * @param id : id searched
     * @return : user found
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
     * Get all post by user
     * @param UserId : id of the user
     * @return : list of post
     */
    public Collection<Post> getAllUserPost(long UserId) {
        return userRepository.getAllUserPost(UserId);
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
        return userRepository.save(user);
    }
}
