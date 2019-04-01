package com.epitech.linkedinspringbootneo4jv1.repository;

import com.epitech.linkedinspringbootneo4jv1.model.School;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface SchoolRepository extends Neo4jRepository<School, Long> {

    /**
     * Get all Schools
     * @return all schools
     */
    @Query("MATCH (s:School)-[ili:IS_LOCATED_IN]->(c:City)-[ii:IS_IN]->(co:Country) RETURN s,ili,c,ii,co")
    Collection<School> getAllSchools();

    /**
     * Get a School by id
     * @param id : id searched
     * @return : School found
     */
    @Query("MATCH (s:School) WHERE ID(s)={id} RETURN s")
    School getById(Long id);

    /**
     * Get schools by city
     * @param cityName : name of the city
     * @return : schools located in in the city
     */
    @Query("MATCH (co:Country)<-[ii:IS_IN]-(c:City)<-[li:IS_LOCATED_IN]-(u:School) WHERE c.name={cityName} RETURN u,c,li,co,ii")
    Collection<School> getAllByCity(String cityName);
}
