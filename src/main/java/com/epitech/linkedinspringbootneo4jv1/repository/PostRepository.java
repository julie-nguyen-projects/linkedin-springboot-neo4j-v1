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
    @Query("MATCH (c:Company) MATCH p=(c)-[r*0..2]-() RETURN c, nodes(p), rels(p)")
    Collection<Company> getAllCompanies();

    /**
     * Get company by id
     * @param id : id of the searched company
     * @return company found
     */
    @Query("MATCH (c:Company) MATCH p=(c)-[r*0..2]-() WHERE ID(c)={id} RETURN c, nodes(p), rels(p)")
    Company getCompanyById(Long id);

    /**
     * Get companies by city
     * @param cityName : name of the city
     * @return : companies located in in the city
     */
    @Query("MATCH (co:Country)<-[ii:IS_IN]-(c:City)<-[li:IS_LOCATED_IN]-(u:Company) WHERE c.name={cityName} RETURN u,c,li,co,ii")
    Collection<Company> getAllCompaniesByCity(String cityName);

    /**
     * Get company by city
     * @param companyName : name of the company
     * @return : company found
     */
    @Query("MATCH (comp:Company) MATCH p=(comp)-[r*0..2]-() WHERE comp.name={companyName} RETURN comp, nodes(p), rels(p)")
    Company getByName(String companyName);

    @Query("MATCH (c:City) WHERE c.name={cityName} CREATE (Company{name: 'Sully Group'})\n" +
            "CREATE (Sully)-[:IS_LOCATED_IN]->(lyon)")
    Company createCompany(Company company, String cityName);
}
