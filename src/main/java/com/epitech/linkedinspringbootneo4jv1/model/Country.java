package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Getter
@Setter
@Builder
@NoArgsConstructor
@NodeEntity

/**
 * Class Country
 */
public class Country {

    /**Id */
    @Id @GeneratedValue
    private Long id;

    /** The name of the country */
    private String name;

    /**
     * CONSTRUCTOR
     * @param _name
     */
    public Country (String _name) {
        name = _name;
    }

    /**
     * CONSTRUCTOR
     * @param _id
     * @param _name
     */
    public Country (Long _id, String _name) {
        id = _id;
        name = _name;
    }
}
