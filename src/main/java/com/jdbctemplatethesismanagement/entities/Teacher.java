package com.jdbctemplatethesismanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Long idTeacher;

    private String firstName;

    private String lastName;

    private String email;

    private String CNP;

    private Integer numberOfStudents;

    private List<Project> projectsList;
}
