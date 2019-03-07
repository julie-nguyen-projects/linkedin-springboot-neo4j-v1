package com.epitech.linkedinspringbootneo4jv1.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.time.LocalDate;

@NodeEntity
public class Experience {

    @Id
    private Long id;
    private LocalDate beginningDate;
    private LocalDate endingDate;
}
