package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@Getter
@Builder
@NodeEntity
public class User {

    @Id
    private Long id;
    private String lastname;
    private String name;

    @Relationship(type = "LIVES_IN")
    private City city;
}
