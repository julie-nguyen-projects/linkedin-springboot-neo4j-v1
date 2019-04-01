package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.Company;
import com.epitech.linkedinspringbootneo4jv1.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Controller for Company class
 */
@RestController
@RequestMapping("/")
public class CompanyController {

    /** Service for Company class */
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * Get all companies
     * @return ResponseEntity : status OK and list of companies in the body
     */
    @GetMapping("/companies")
    public ResponseEntity<Collection<Company>> getAll() {
        return ResponseEntity.ok().body(companyService.getAll());
    }
}
