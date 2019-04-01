package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.School;
import com.epitech.linkedinspringbootneo4jv1.service.SchoolService;
import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/schools")
    public ResponseEntity<Collection<School>> getAll() {
        return ResponseEntity.ok().body(schoolService.getAll());
    }
}
