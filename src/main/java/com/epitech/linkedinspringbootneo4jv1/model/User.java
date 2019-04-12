package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * User class
 */
@Getter
@Builder
@NodeEntity
public class User {

    /** id */
    @Id @GeneratedValue
    private Long id;

    /** Lastname */
    private String lastname;

    /** Name */
    private String name;

    /** City where the user lives */
    @Relationship(type = "LIVES_IN")
    private City city;

    /** User's experiences */
    @Relationship(type = "HAS_EXPERIENCES")
    private List<Experience> experiences;

    /** User's posts */
    @Relationship(type = "HAS_POSTS")
    private List<Post> posts;

    /**
     * CONSTRUCTOR
     */
    public User () {
    }

    /**
     * CONSTRUCTOR
     * @param _lastname
     * @param _name
     */
    public User (String _lastname, String _name) {
        lastname  =_lastname;
        name = _name;
    }

    /**
     * CONSTRUCTOR
     * @param _lastname
     * @param _name
     * @param _city
     */
    public User (String _lastname, String _name, City _city) {
        lastname = _lastname;
        name = _name;
        city = _city;
    }

    /**
     * CONSTRUCTOR
     * @param _id
     * @param _lastname
     * @param _name
     * @param _city
     */
    public User (Long _id, String _lastname, String _name, City _city) {
        id = _id;
        lastname = _lastname;
        name = _name;
        city = _city;
    }

    /**
     * Constructor
     * @param _id
     * @param _lastname
     * @param _name
     * @param _city
     * @param _experiences
     */
    public User (Long _id, String _lastname, String _name, City _city, List<Experience> _experiences) {
        id = _id;
        lastname = _lastname;
        name = _name;
        city = _city;
        experiences = _experiences;
    }

    public User (Long _id, String _lastname, String _name, City _city, List<Experience> _experiences, List<Post> _posts) {
        id = _id;
        lastname = _lastname;
        name = _name;
        city = _city;
        experiences = _experiences;
        posts = _posts;
    }

}
