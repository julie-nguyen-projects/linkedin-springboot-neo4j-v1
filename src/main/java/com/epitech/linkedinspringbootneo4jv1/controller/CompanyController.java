package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.Company;
import com.epitech.linkedinspringbootneo4jv1.model.User;
import com.epitech.linkedinspringbootneo4jv1.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Company> getByName(@PathVariable String companyName) {
        return ResponseEntity.ok().body(companyService.getByName(companyName));
    }

    /**
     * Get users by company
     * @param companyName : name of the company
     * @return : ResponseEntity : status OK and users who work in that company in the body
     */
    @GetMapping("/companies/users/{companyName}")
    public ResponseEntity<Collection<User>> getUsersByCompany(@PathVariable String companyName) {
        return ResponseEntity.ok().body(companyService.getUsersByCompanyName(companyName));
    }

    /**
     * Create a company
     * @param company : company to create
     * @return : created company
     */
    @PostMapping("/companies")
    public Company createCompany(@RequestBody Company company) {
        return companyService.create(company);
    }
}
