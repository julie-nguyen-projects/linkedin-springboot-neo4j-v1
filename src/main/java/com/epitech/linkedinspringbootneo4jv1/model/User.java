package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * User class
 */
@Getter
@Builder
@NodeEntity
public class User {

    /** id */
    @Id
    private Long id;

    /** Lastname */
    private String lastname;

    /** Name */
    private String name;

    /** City where the user lives */
    @Relationship(type = "LIVES_IN")
    private City city;

    /** User's experiences */
    @Relationship(type = "HAS_EXPERIENCES")
    private List<Experience> experiences;
}
