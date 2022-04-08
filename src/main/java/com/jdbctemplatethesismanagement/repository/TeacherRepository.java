package com.jdbctemplatethesismanagement.repository;

import com.jdbctemplatethesismanagement.entities.Teacher;

import java.util.List;

public interface TeacherRepository {

    int save(Teacher teacher);
    int update(Teacher teacher);
    Teacher findById(Long id);
    int deleteById(Long id);
    List<Teacher> findAll();


}
