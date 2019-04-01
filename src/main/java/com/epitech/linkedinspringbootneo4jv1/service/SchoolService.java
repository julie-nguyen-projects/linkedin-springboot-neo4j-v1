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

    public Collection<School> getAll() {
        return schoolRepository.getAllSchools();
    }
}
