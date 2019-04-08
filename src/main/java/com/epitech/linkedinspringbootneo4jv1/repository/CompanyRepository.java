package com.epitech.linkedinspringbootneo4jv1.repository;

import com.epitech.linkedinspringbootneo4jv1.model.Company;
import com.epitech.linkedinspringbootneo4jv1.model.User;
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

    @Query("MATCH (city {name: {cityName}})" +
            "CREATE (company:Company {name: {companyName}}) " +
            "CREATE (company)-[:IS_LOCATED_IN]->(city) RETURN company")
    Company createCompany(String companyName, String cityName);

    /**
     * Get users by company
     * @param companyName : name of the company
     * @return : users who work in that company
     */
    @Query("MATCH (u:User)-[he:HAS_EXPERIENCES]->(e:Experience)-[wc:WORK_COMPANY]->(c:Company) " +
            "WHERE c.name={companyName} OPTIONAL MATCH p=(u)-[r*0..2]-() RETURN u, nodes(p), rels(p)")
    Collection<User> getUsersByCompanyName(String companyName);
}
