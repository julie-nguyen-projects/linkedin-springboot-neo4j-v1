package com.epitech.linkedinspringbootneo4jv1.repository;

import com.epitech.linkedinspringbootneo4jv1.model.Country;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")
public interface CountryRepository  extends Neo4jRepository<Country, Long> {
    /**
     * Get a country by Id
     * @param id : id searched
     * @return : country found
     */
    @Query("MATCH (c:Country) WHERE ID(c)={id} RETURN c")
    Optional<Country> findById(@Param("id") Long id);

    /**
     * Get a country by Id
     * @param name : name of the searched country
     * @return : country found
     */
    @Query("MATCH (c:Country) WHERE c.name = {name} return c")
    Optional<Country> findByName(@Param("name") String name);

    /**
     * Get all countries even those without relationships
     * @return : all countries
     */
    @Query("MATCH (co:Country) RETURN co")
    Collection<Country> getAllCountries();

    /**
     * Create/Update a country
     * @param country: country to create/update
     * @return country created/updated
     */
    Country save(Country country);

    /**
     * Delete a country using his id
     * @param id
     */
    void deleteById(Long id);
}
