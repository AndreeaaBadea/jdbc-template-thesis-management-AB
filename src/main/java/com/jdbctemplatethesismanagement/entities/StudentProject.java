package com.jdbctemplatethesismanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProject {

    private Integer idStudentProject;

    private Student student;

    private Project project;





}
