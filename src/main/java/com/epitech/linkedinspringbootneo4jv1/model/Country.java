package com.epitech.linkedinspringbootneo4jv1.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Country {

    @Id
    private Long id;
    private String name;
}
