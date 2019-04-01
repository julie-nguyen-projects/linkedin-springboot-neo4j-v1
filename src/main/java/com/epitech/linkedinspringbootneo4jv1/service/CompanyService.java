package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.Company;
import com.epitech.linkedinspringbootneo4jv1.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Service for Company class
 */
@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * Get all companies
     * @return list of companies
     */
    public Collection<Company> getAll() {
        return companyRepository.getAllCompanies();
    }
}
