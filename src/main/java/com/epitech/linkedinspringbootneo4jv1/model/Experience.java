package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Date;

@Getter
@Builder
@NodeEntity
public class Experience {

    @Id
    private Long id;
    private Date beginningDate;
    private Date endingDate;

    @Relationship(type = "WORK_COMPANY")
    private Company company;

    @Relationship(type = "WORK_COMPANY")
    private School schoolToWork;

    @Relationship(type = "STUDY")
    private School schoolToStudy;
}
