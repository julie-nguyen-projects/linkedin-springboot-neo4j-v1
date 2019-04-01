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
}
