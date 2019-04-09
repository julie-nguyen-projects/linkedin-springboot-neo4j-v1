package com.epitech.linkedinspringbootneo4jv1.repository;
import com.epitech.linkedinspringbootneo4jv1.model.City;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface CityRepository extends Neo4jRepository<City, Long>{

    /**
     * Get a city by Id
     * @param id : id searched
     * @return : city found
     */
    @Query("MATCH (c:City) WHERE ID(c)={id} RETURN c")
    Optional<City> findById(@Param("id") Long id);

    /**
     * Get a city by Name
     * @param name : name searched
     * @return : city found
     */
    @Query("MATCH (c:City) WHERE c.name={name} RETURN c")
    Optional<City> findByName(@Param("name") String name);

    /**
     * Get all cities even those without relationships
     * @return : all cities
     */
    @Query("MATCH (ci:City) OPTIONAL MATCH (ci:City)-[ii:IS_IN]->(co:Country) RETURN ci,ii,co")
    Collection<City> getAllCities();

    /**
     * Get cities by country
     * @param countryName : name of the city
     * @return : cities in the country
     */
    @Query("MATCH (co:Country)<-[ii:IS_IN]-(c:City) WHERE co.name={countryName} RETURN c,ii,co")
    Collection<City> getAllCitiesByCountry(@Param("countryName") String countryName);

    /**
     * Create a new city
     * @param city : city to create
     * @return city created
     */
    City save(City city);
}
