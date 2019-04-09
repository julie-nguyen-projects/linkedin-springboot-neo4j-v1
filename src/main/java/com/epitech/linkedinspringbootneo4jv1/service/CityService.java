package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.City;
import com.epitech.linkedinspringbootneo4jv1.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService (CityRepository cityRepository) { this.cityRepository = cityRepository; }

    public City getById(Long id) { return this.cityRepository.findById(id).orElse(null); }

    public City getByName(String name) { return this.cityRepository.findByName(name).orElse(null); }

    public Collection<City> getAll() { return this.cityRepository.getAllCities(); }

    public Collection<City> getAllbyCountry(String name) { return this.cityRepository.getAllCitiesByCountry(name); }

    public boolean cityExist(String cityName) {
        Collection<City> allCities = this.getAll();
        City cityFound = allCities.stream()
                .filter(city -> city.getName().equalsIgnoreCase(cityName))
                .findAny()
                .orElse(null);
        return cityFound != null;
    }

    public City createCity (City city) {
        if(!this.cityExist(city.getName())){
            return this.cityRepository.save(city);
        }
        return null;
    }

    public City updateCity(Long cityId, City city) {
        City existingCity = this.getById(cityId);
        if (existingCity != null) {
            existingCity.setName(city.getName());
            existingCity.setCountry(city.getCountry());
            return this.cityRepository.save(existingCity);
        }
        return this.cityRepository.save(city);
    }
}