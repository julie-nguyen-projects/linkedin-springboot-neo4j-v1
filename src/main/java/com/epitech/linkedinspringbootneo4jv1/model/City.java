package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * City class
 */
@Getter
@Builder
@NodeEntity
public class City {

    /** id */
    @Id @GeneratedValue
    private Long id;

    /** City's name */
    private String name;

    /** Country of the city */
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
