package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * City class
 */
@Getter
@Builder
@NodeEntity
public class City {

    /** id */
    @Id
    private Long id;

    /** City's name */
    private String name;

    /** Country of the city */
    @Relationship(type = "IS_IN")
    private Country country;
}
