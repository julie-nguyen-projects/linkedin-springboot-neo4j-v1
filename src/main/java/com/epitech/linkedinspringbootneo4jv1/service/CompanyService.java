package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.Company;
import com.epitech.linkedinspringbootneo4jv1.model.User;
import com.epitech.linkedinspringbootneo4jv1.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.net.URI;
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

    /**
     * Get company by id
     * @param id : id of the searched company
     * @return company found
     */
    public Company getById(Long id) {
        return companyRepository.getCompanyById(id);
    }

    /**
     * Get all companies by city
     * @param cityName : name of the city
     * @return : companies located in the city
     */
    public Collection<Company> getAllByCity(String cityName) {
        return companyRepository.getAllCompaniesByCity(cityName);
    }

    /**
     * Get company by name
     * @param companyName : name of the company
     * @return : found company
     */
    public Company getByName(String companyName) {
        return companyRepository.getByName(companyName);
    }

    /**
     * Create a company
     * @param company : company to create
     * @return : created company
     */
    public Company create(Company company) {
        // TODO check if city exists
        return companyRepository.createCompany(company.getName(), company.getCity().getName());
    }
}
