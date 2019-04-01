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

    /**
     * Get company by id
     * @param id : id of the searched company
     * @return company found
     */
    @Query("MATCH (c:Company) WHERE ID(c)={id} RETURN c")
    Company getCompanyById(Long id);

    /**
     * Get companies by city
     * @param cityName : name of the city
     * @return : companies located in in the city
     */
    @Query("MATCH (co:Country)<-[ii:IS_IN]-(c:City)<-[li:IS_LOCATED_IN]-(u:Company) WHERE c.name={cityName} RETURN u,c,li,co,ii")
    Collection<Company> getAllCompaniesByCity(String cityName);
}
