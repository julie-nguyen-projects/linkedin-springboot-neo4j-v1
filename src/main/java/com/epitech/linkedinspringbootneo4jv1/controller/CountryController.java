package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.Country;
import com.epitech.linkedinspringbootneo4jv1.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class CountryController {

    private final CountryService countryService;

    /**
     * CONSTRUCTOR
     * @param countryService
     */
    @Autowired
    public CountryController(CountryService countryService) { this.countryService = countryService; }

    /**
     * Get all coutry
     * @return Collection of country
     */
    @GetMapping("/countries")
    public Collection<Country> getAll() { return this.countryService.getAllCountries(); }

    /**
     * Get a country by id
     * @param id The id of the country
     * @return the country found
     */
    @GetMapping("/countries/id/{id}")
    public Country getById(@PathVariable("id") Long id) { return this.countryService.getById(id); }

    /**
     * Get a country by name
     * @param name The name of the country
     * @return the country found
     */
    @GetMapping("/countries/name/{name}")
    public Country getByName(@PathVariable("name") String name) { return this.countryService.getByName(name); }

    /**
     * Create a new country
     * @param country
     * @return The country created
     */
    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) { return this.countryService.createCountry(country); }

    /**
     * Update an existing country
     * @param id The id of the existing country
     * @param country the new value of the country
     * @return The updated country
     */
    @PutMapping("/countries/id/{id}")
    public Country updateCountry(@PathVariable("id") Long id, @RequestBody Country country) { return this.countryService.updateCountry(id, country); }

    /**
     * Delete a country
     * @param id The id of the country
     */
    @DeleteMapping("/countries/id/{id}")
    public void deleteCountry(@PathVariable("id") Long id) { this.countryService.deleteCountry(id); }
}
