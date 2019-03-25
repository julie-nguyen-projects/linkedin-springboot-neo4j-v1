package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Class for School
 */
@Getter
@Builder
@NodeEntity
public class School {

    /** id */
    @Id
    private Long id;

    /** name */
    private String name;

    /** city of the school */
    @Relationship(type = "IS_LOCATED_IN")
    private City city;
}
