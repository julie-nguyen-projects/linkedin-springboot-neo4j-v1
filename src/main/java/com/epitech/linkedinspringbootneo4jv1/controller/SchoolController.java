package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.School;
import com.epitech.linkedinspringbootneo4jv1.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Controller for School class
 */
@RestController
@RequestMapping("/")
public class SchoolController {

    /** Service for School class */
    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    /**
     * Get all Schools
     * @return ResponseEntity : status OK and list of Schools in the body
     */
    @GetMapping("/schools")
    public ResponseEntity<Collection<School>> getAll() {
        return ResponseEntity.ok().body(schoolService.getAll());
    }

    /**
     * Get school by id
     * @param id : id of the searched school
     * @return ResponseEntity : status OK and found school in the body
     */
    @GetMapping("/schools/id/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        return ResponseEntity.ok().body(schoolService.getById(id));
    }

    /**
     * Get all schools by city
     * @param cityName : name of the city
     * @return : ResponseEntity : status OK and schools located in the city in the body
     */
    @GetMapping("/schools/city/{cityName}")
    public ResponseEntity<Collection<School>> getAllSchoolsByCity(@PathVariable String cityName) {
        return ResponseEntity.ok().body(schoolService.getAllByCity(cityName));
    }

    /**
     * Get school by name
     * @param schoolName : name of the school
     * @return : ResponseEntity : status OK and found school in the body
     */
    @GetMapping("/schools/name/{schoolName}")
    public ResponseEntity<School> getSchoolByName(@PathVariable String schoolName) {
        return ResponseEntity.ok().body(schoolService.getSchoolByName(schoolName));
    }
}
