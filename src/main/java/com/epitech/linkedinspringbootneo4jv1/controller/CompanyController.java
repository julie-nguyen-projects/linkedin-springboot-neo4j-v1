package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.Company;
import com.epitech.linkedinspringbootneo4jv1.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * Get company by id
     * @param id : id of the searched company
     * @return company found
     */
    @GetMapping("/companies/id/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok().body(companyService.getById(id));
    }

    /**
     * Get all companies by city
     * @param cityName : name of the city
     * @return : companies located in the city
     */
    @GetMapping("/companies/city/{cityName}")
    public ResponseEntity<Collection<Company>> getAllCompaniesByCity(@PathVariable String cityName) {
        return ResponseEntity.ok().body(companyService.getAllByCity(cityName));
    }

    /**
     * Get company by name
     * @param companyName : name of the company
     * @return : ResponseEntity : status OK and found company in the body
     */
    @GetMapping("/companies/name/{companyName}")
    public ResponseEntity<Company> getSchoolByName(@PathVariable String companyName) {
        return ResponseEntity.ok().body(companyService.getByName(companyName));
    }
}
