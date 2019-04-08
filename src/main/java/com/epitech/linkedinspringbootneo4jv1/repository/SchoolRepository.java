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
    @Query("MATCH (s:School) MATCH p=(s)-[r*0..2]-() RETURN s, nodes(p), rels(p)")
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

    /**
     * Get school by name
     * @param schoolName : name of the school
     * @return : found school
     */
    @Query("MATCH (co:Country)<-[ii:IS_IN]-(c:City)<-[li:IS_LOCATED_IN]-(sch:School) WHERE sch.name={schoolName} RETURN sch,c,li,co,ii")
    School getSchoolByName(String schoolName);
}
