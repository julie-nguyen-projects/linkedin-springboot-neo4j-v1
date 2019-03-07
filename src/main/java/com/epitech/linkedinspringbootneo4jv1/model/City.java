package com.epitech.linkedinspringbootneo4jv1.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class City {

    @Id
    private Long id;
    private String name;

    @Relationship(type = "IS_IN", direction = Relationship.INCOMING)
    private Country country;
}
