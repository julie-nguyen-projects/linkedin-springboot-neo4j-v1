package com.epitech.linkedinspringbootneo4jv1.repository;


import com.epitech.linkedinspringbootneo4jv1.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends Neo4jRepository<User, Long> {

    /**
     * Get a user by id
     * @param id : id searched
     * @return : user found
     */
    @Query("MATCH (u:User) WHERE ID(u)={id} RETURN u")
    Optional<User> findById(@Param("id") Long id);

    /**
     * Get all users
     * @return : all users
     */
    @Query("MATCH (u:User)-[li:LIVES_IN]->(ci:City)-[ii:IS_IN]->(co:Country) RETURN u,li,ci,ii,co")
    Collection<User> getAllUsers();

    /**
     * Get users by city
     * @param cityName : name of the city
     * @return : users living in the city
     */
    @Query("MATCH (co:Country)<-[ii:IS_IN]-(c:City)<-[li:LIVES_IN]-(u:User) WHERE c.name={cityName} RETURN u,c,li,co,ii")
    Collection<User> getAllUsersByCity(String cityName);
}
