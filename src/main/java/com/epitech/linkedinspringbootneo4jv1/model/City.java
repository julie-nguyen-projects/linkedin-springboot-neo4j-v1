package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * City class
 */
@Getter
@Setter
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

    /**
     * CONSTRUCTOR
     */
    public City () {
    }

    /**
     * CONSTRUCTOR
     * @param _name
     */
    public City (String _name) {
        name = _name;
    }

    /**
     * CONSTRUCTOR
     * @param _name
     * @param _country
     */
    public City (String _name, Country _country) {
        name = _name;
        country = _country;
    }

    /**
     * CONSTRUCTOR
     * @param _id
     * @param _name
     * @param _country
     */
    public City (Long _id, String _name, Country _country) {
        id = _id;
        name = _name;
        country = _country;
    }
}
