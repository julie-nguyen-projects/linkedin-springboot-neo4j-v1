package com.epitech.linkedinspringbootneo4jv1.controller;

import com.epitech.linkedinspringbootneo4jv1.model.City;
import com.epitech.linkedinspringbootneo4jv1.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/cities/name/{name}")
    public City getByName(@PathVariable("name") String name) { return this.cityService.getByName(name); }

    @GetMapping("/cities")
    public Collection<City> getAll() { return this.cityService.getAll(); }

    @GetMapping("/cities/country/{countryName}")
    public Collection<City> getAllByCountry(@PathVariable("countryName")String coutryName) {
        return this.cityService.getAllbyCountry(coutryName);
    }

    /**
     * Create a user
     * @param city : city to create
     * @return city created
     */
    @PostMapping("/cities")
    public City addCity (@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping("/cities/id/{id}")
    public City updateCity (@PathVariable Long id, @RequestBody City city) {
        return this.cityService.updateCity(id, city);
    }

    @DeleteMapping("/cities/id/{id}")
    public void deleteCity(@PathVariable("id") Long id) { this.cityService.deleteCity(id); }
}
