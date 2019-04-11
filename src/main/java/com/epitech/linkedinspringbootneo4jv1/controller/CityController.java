package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.City;
import com.epitech.linkedinspringbootneo4jv1.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**Controller for City class */
@RestController
@RequestMapping("/")
public class CityController {


    private final CityService cityService;

    /**
     * CONSTRUCTOR
     * @param cityService
     */
    @Autowired
    public CityController(CityService cityService) { this.cityService = cityService; }

    /**
     * Get a city by name
     * @param name The name of the city
     * @return The city found
     */
    @GetMapping("/cities/name/{name}")
    public City getByName(@PathVariable("name") String name) { return this.cityService.getByName(name); }

    /**
     * Get all cities
     * @return Collection of all cities
     */
    @GetMapping("/cities")
    public Collection<City> getAll() { return this.cityService.getAll(); }

    /**
     * Get all cities by country
     * @param coutryName The name of the country
     * @return A collection of cities
     */
    @GetMapping("/cities/country/{countryName}")
    public Collection<City> getAllByCountry(@PathVariable("countryName")String coutryName) {
        return this.cityService.getAllbyCountry(coutryName);
    }

    /**
     * Create a city
     * @param city : city to create
     * @return city created
     */
    @PostMapping("/cities")
    public City addCity (@RequestBody City city) {
        return cityService.createCity(city);
    }

    /**
     * Update a city
     * @param id The id of the existed city
     * @param city The new datas of the city
     * @return The updated city
     */
    @PutMapping("/cities/id/{id}")
    public City updateCity (@PathVariable Long id, @RequestBody City city) {
        return this.cityService.updateCity(id, city);
    }

    /**
     * Delete a city
     * @param id The id of the city
     */
    @DeleteMapping("/cities/id/{id}")
    public void deleteCity(@PathVariable("id") Long id) { this.cityService.deleteCity(id); }
}
