package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Getter
@Builder
@NodeEntity
public class City {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @Relationship(type = "IS_IN")
    private Country country;

    public City () {
    }

    public City (String _name) {
        name = _name;
    }

    public City (String _name, Country _country) {
        name = _name;
        country = _country;
    }

    public City (Long _id, String _name, Country _country) {
        id = _id;
        name = _name;
        country = _country;
    }
}
