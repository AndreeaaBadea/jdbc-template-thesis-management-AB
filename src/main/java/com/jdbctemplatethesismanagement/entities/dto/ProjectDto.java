package com.jdbctemplatethesismanagement.entities.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jdbctemplatethesismanagement.entities.StudentProject;
import com.jdbctemplatethesismanagement.entities.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private Long idProject;

    @JsonIgnore
    private StudentProject studentProject;

    @JsonIgnore
    private Long idStudentProject;

    @JsonIgnore
    private Teacher teacher;

    private Long idTeacher;

    private String projectTitle;

    private String projectDescription;

    private Boolean projectAvailability;




}
