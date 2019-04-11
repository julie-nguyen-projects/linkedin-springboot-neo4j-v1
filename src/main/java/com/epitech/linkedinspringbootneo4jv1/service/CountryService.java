package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.Country;
import com.epitech.linkedinspringbootneo4jv1.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CountryService {

    /**The repository of the Country class */
    private CountryRepository countryRepository;

    /**
     * CONSTRUCTOR
     * @param countryRepository
     */
    public CountryService (CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /**
     * Get a country by id
     * @param id The id of the country
     * @return The country found
     */
    public Country getById(Long id) {
        // TODO : exception
        return this.countryRepository.findById(id).orElse(null);
    }

    /**
     * Get a country by name
     * @param name the name of the country
     * @return The country found
     */
    public Country getByName(String name) {
        // TODO : exception
        return this.countryRepository.findByName(name).orElse(null);
    }

    /**
     * Get all countries
     * @return A collection of countries
     */
    public Collection<Country> getAllCountries() { return this.countryRepository.getAllCountries(); }

    /**
     * Check if a country already exists
     * @param countryName the name of the country
     * @return true or false
     */
    public boolean countryExists(String countryName) {
        Collection<Country> allCountries = this.getAllCountries();
        Country countryFound = allCountries.stream()
                .filter(country -> country.getName().equalsIgnoreCase(countryName))
                .findAny()
                .orElse(null);
        return countryFound != null;
    }

    /**
     * Create a country if it doesn't exist
     * @param country
     * @return
     */
    public Country createCountry(Country country) {
        if (!this.countryExists(country.getName())){
            return this.countryRepository.save(country);
        }
        System.out.println("Error: can not create country with existing name.");
        // TODO : exception
        return null;
    }

    /**
     * Update an existed country with a given id.
     * The function add a new country if it doesn't exist.
     * @param countryId
     * @param country
     * @return
     */
    public Country updateCountry(Long countryId, Country country) {
        Country existingCountry = this.getById(countryId);
        if (existingCountry != null) {
            existingCountry.setName(country.getName());
            this.countryRepository.save(existingCountry);
        }
        return this.countryRepository.save(existingCountry);
    }

    /**
     * Delete a country with the given id
     * @param id the id of the country
     */
    public void deleteCountry(Long id) {
        this.countryRepository.deleteById(id);
    }

}
