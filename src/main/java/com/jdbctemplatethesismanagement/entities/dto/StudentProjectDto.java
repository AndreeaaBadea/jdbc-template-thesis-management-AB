package com.jdbctemplatethesismanagement.entities.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jdbctemplatethesismanagement.entities.Project;
import com.jdbctemplatethesismanagement.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProjectDto {

    private Integer idStudentProject;

    private Integer idStudent;

    private Integer idProject;

    @JsonIgnore
    private Student student;

    @JsonIgnore
    private Project project;


}
