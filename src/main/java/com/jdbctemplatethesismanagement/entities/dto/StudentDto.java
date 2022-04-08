package com.jdbctemplatethesismanagement.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jdbctemplatethesismanagement.entities.StudentProject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long idStudent;

    private String firstName;

    private String lastName;

    private String email;

    private String CNP;

    @JsonIgnore
    private StudentProject studentProject;

    private Integer idStudentProject;


}
