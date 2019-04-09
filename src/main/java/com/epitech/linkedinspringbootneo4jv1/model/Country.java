package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Getter
@Builder
@NoArgsConstructor
@NodeEntity
public class Country {

    @Id @GeneratedValue
    private Long id;
    private String name;

    public Country (String _name) {
        name = _name;
    }

    public Country (Long _id, String _name) {
        id = _id;
        name = _name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
