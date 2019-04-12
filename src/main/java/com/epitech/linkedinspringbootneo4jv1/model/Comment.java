package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Getter
@Builder
@NodeEntity
public class Comment {
    @Id
    private Long id;
    /** Comment's Content */
    private String content;
    /** Comment's Creation Date */
    private String creationDate;

}
