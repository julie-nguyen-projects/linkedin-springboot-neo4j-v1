package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.School;
import com.epitech.linkedinspringbootneo4jv1.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Service for School Class
 */
@Service
public class SchoolService {

    /** Repository for School class */
    private SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    /**
     * Get all Schools
     * @return all schools
     */
    public Collection<School> getAll() {
        return schoolRepository.getAllSchools();
    }

    /**
     * Get school by id
     * @param id : id of the searched school
     * @return school found
     */
    public School getById(Long id) {
        return schoolRepository.getById(id);
    }

    /**
     * Get all schools by city
     * @param cityName : name of the city
     * @return : schools located in the city
     */
    public Collection<School> getAllByCity(String cityName) {
        return schoolRepository.getAllByCity(cityName);
    }
}
