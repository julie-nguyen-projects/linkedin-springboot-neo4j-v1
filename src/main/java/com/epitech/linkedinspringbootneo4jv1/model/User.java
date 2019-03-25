package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@Getter
@Builder
@NodeEntity
public class User {

    @Id @GeneratedValue
    private Long id;
    private String lastname;
    private String name;

    @Relationship(type = "LIVES_IN")
    private City city;

    public User () {
    }

    public User (String _lastname, String _name) {
        lastname  =_lastname;
        name = _name;
    }

    public User (String _lastname, String _name, City _city) {
        lastname = _lastname;
        name = _name;
        city = _city;
    }

    public User (Long _id, String _lastname, String _name, City _city) {
        id = _id;
        lastname = _lastname;
        name = _name;
        city = _city;
    }
}
