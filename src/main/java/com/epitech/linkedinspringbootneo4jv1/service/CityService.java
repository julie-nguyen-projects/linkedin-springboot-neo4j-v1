package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.City;
import com.epitech.linkedinspringbootneo4jv1.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService (CityRepository cityRepository) { this.cityRepository = cityRepository; }

    public City getByName(String name) { return this.cityRepository.findByName(name).orElse(null); }

    public Collection<City> getAll() { return this.cityRepository.getAllCities(); }

    public Collection<City> getAllbyCountry(String name) { return this.cityRepository.getAllCitiesByCountry(name); }

    public boolean cityExist(String name) {
        if (getByName(name) == null) {
            return false;
        }
        return true;
    }

    public City save (City city) { return this.cityRepository.save(city); }
}