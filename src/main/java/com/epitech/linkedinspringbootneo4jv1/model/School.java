package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Getter
@Builder
@NodeEntity
public class School {


    @Id
    private Long id;
    private String name;
    @Relationship(type = "IS_LOCATED_IN")
    private City city;
}
