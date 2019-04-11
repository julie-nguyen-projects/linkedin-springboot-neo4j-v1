package com.epitech.linkedinspringbootneo4jv1.service;

import com.epitech.linkedinspringbootneo4jv1.model.City;
import com.epitech.linkedinspringbootneo4jv1.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CityService {

    /**Repository for the City class */
    private CityRepository cityRepository;

    /**
     * CONSTRUCTOR
     * @param cityRepository
     */
    public CityService (CityRepository cityRepository) { this.cityRepository = cityRepository; }

    /**
     * Get a city by id
     * @param id The id of the city searched
     * @return The city found or null
     */
    public City getById(Long id) {
        // TODO : exception
        return this.cityRepository.findById(id).orElse(null);
    }

    /**
     * Get a city by name
     * @param name The name of the search city
     * @return The city found or null
     */
    public City getByName(String name) {
        // TODO : exception
        return this.cityRepository.findByName(name).orElse(null);
    }

    /**
     * Get all cities
     * @return A collection with all cities
     */
    public Collection<City> getAll() { return this.cityRepository.getAllCities(); }

    /**
     * Get all cities of a specific country
     * @param name The name of the country
     * @return A collection of cities from the given country.
     */
    public Collection<City> getAllbyCountry(String name) { return this.cityRepository.getAllCitiesByCountry(name); }

    /**
     * Check if a city already exists
     * @param cityName the name of the city
     * @return true or false
     */
    public boolean cityExist(String cityName) {
        Collection<City> allCities = this.getAll();
        City cityFound = allCities.stream()
                .filter(city -> city.getName().equalsIgnoreCase(cityName))
                .findAny()
                .orElse(null);
        return cityFound != null;
    }

    /**
     * Create a new city if it doesn't exist
     * @param city the city
     * @return the created city
     */
    public City createCity (City city) {
        if(!this.cityExist(city.getName())){
            return this.cityRepository.save(city);
        }
        System.out.println("Error: can not create city with existing name.");
        // TODO : exception
        return null;
    }

    /**
     * Update an existed city with a given id.
     * The function add a new city if it doesn't exist.
     * @param cityId The id of the existing city
     * @param city The city with the modified datas.
     * @return The updated city
     */
    public City updateCity(Long cityId, City city) {
        City existingCity = this.getById(cityId);
        if (existingCity != null) {
            existingCity.setName(city.getName());
            existingCity.setCountry(city.getCountry());
            return this.cityRepository.save(existingCity);
        }
        return this.cityRepository.save(city);
    }

    /**
     * Delete a city with the given id
     * @param id the id of the city
     */
    public void deleteCity(Long id) {
        this.cityRepository.delete(id);
    }
}