package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;


@Getter
@Setter
@Builder
@NodeEntity
public class Post {
    @Id
    private Long id;
    /** Post's Content */
    private String content;
    /** Post's comments */
    @Relationship(type = "HAS_COMMENTS")
    private List<Comment> comments;
    /** Post's Creation Date */
    private String creationDate;

}
