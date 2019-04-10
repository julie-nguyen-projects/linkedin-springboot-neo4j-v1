package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.Country;
import com.epitech.linkedinspringbootneo4jv1.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public Collection<Country> getAll() { return this.countryService.getAllCountries(); }

    @GetMapping("/countries/id/{id}")
    public Country getById(@PathVariable("id") Long id) { return this.countryService.getById(id); }

    @GetMapping("/countries/name/{name}")
    public Country getByName(@PathVariable("name") String name) { return this.countryService.getByName(name); }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) { return this.countryService.createCountry(country); }

    @PutMapping("/countries/id/{id}")
    public Country updateCountry(@PathVariable("id") Long id, @RequestBody Country country) { return this.countryService.updateCountry(id, country); }

    @DeleteMapping("/countries/id/{id}")
    public void deleteCountry(@PathVariable("id") Long id) { this.countryService.deleteCountry(id); }
}
