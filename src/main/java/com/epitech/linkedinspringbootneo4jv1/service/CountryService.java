package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.Country;
import com.epitech.linkedinspringbootneo4jv1.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService (CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country getById(Long id) { return this.countryRepository.findById(id).orElse(null); }

    public Country getByName(String name) { return this.countryRepository.findByName(name).orElse(null); }

    public Collection<Country> getAllCountries() { return this.countryRepository.getAllCountries(); }

    public boolean countryExists(String countryName) {
        Collection<Country> allCountries = this.getAllCountries();
        Country countryFound = allCountries.stream()
                .filter(country -> country.getName().equalsIgnoreCase(countryName))
                .findAny()
                .orElse(null);
        return countryFound != null;
    }

    public Country createCountry(Country country) {
        if (!this.countryExists(country.getName())){
            return this.countryRepository.save(country);
        }
        return null;
    }

    public Country updateCountry(Long countryId, Country country) {
        Country existingCountry = this.getById(countryId);
        if (existingCountry != null) {
            existingCountry.setName(country.getName());
            this.countryRepository.save(existingCountry);
        }
        return this.countryRepository.save(country);
    }

}
