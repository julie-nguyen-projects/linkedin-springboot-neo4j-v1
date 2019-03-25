package com.epitech.linkedinspringbootneo4jv1.model;

import lombok.Builder;
import lombok.Getter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Class for Experience
 */
@Getter
@Builder
@NodeEntity
public class Experience {

    /** id */
    @Id
    private Long id;

    /** Beginning date */
    private String beginningDate;

    /** Ending date */
    private String endingDate;

    /** Work experience linked to a company */
    @Relationship(type = "WORK_COMPANY")
    private Company company;

    /** Work experience linked to a school */
    @Relationship(type = "WORK_SCHOOL")
    private School schoolToWork;

    /** Study experience */
    @Relationship(type = "STUDY")
    private School schoolToStudy;
}
