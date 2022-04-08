package com.jdbctemplatethesismanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private Long idProject;

    private Teacher teacher;

    private StudentProject studentProject;

    private String projectTitle;

    private String projectDescription;

    private Boolean projectAvailability;

}
