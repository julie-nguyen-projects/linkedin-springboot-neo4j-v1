package com.epitech.linkedinspringbootneo4jv1.repository;


import com.epitech.linkedinspringbootneo4jv1.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User)-[li:LIVES_IN]->(ci:City)-[ii:IS_IN]->(co:Country) RETURN u,li,ci,ii,co")
    Collection<User> getAllUsers();
}
