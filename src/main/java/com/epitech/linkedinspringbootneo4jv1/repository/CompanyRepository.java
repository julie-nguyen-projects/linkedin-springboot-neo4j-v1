package com.epitech.linkedinspringbootneo4jv1.repository;

import com.epitech.linkedinspringbootneo4jv1.model.Company;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface CompanyRepository extends Neo4jRepository<Company, Long> {

    /**
     * Get all companies
     * @return list of companies
     */
    @Query("MATCH (cy:Company)-[ili:IS_LOCATED_IN]->(c:City)-[ii:IS_IN]->(co:Country) RETURN cy,ili,c,ii,co")
    Collection<Company> getAllCompanies();
}
