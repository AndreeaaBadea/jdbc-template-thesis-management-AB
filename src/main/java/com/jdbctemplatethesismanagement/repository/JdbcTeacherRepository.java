package com.jdbctemplatethesismanagement.repository;

import com.jdbctemplatethesismanagement.entities.Project;
import com.jdbctemplatethesismanagement.entities.Teacher;
import com.jdbctemplatethesismanagement.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.tinylog.Logger;

import java.util.List;

@Repository
public class JdbcTeacherRepository implements TeacherRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Teacher teacher) {
        return jdbcTemplate.update("INSERT INTO teachers (first_name, last_name, email, cnp, number_of_students) VALUES(?, ?, ?, ?, ?)",
                teacher.getIdTeacher(), teacher.getFirstName(), teacher.getLastName(), teacher.getEmail(), teacher.getCNP(), teacher.getNumberOfStudents());
    }

    @Override
    public int update(Teacher teacher) {
        return jdbcTemplate.update("UPDATE teachers SET first_name=?, last_name=?, email=?, cnp=?, number_of_students=? WHERE id_teacher = ?",
                teacher.getFirstName(), teacher.getLastName(), teacher.getEmail(), teacher.getCNP(), teacher.getNumberOfStudents(), teacher.getIdTeacher());
    }

    @Override
    public Teacher findById(Long id) {
       try{
           Teacher teacher = jdbcTemplate.queryForObject("SELECT * FROM teachers WHERE id_teacher = ?",
                   BeanPropertyRowMapper.newInstance(Teacher.class), id);
           return teacher;
       } catch (ResourceNotFoundException e) {
           throw new ResourceNotFoundException("Not found Teacher with id = " + id);
       }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM teachers WHERE id_teacher = ?", id);
    }

    @Override
    public List<Teacher> findAll(){
        return jdbcTemplate.query("SELECT * FROM teachers", BeanPropertyRowMapper.newInstance(Teacher.class));
    }


    public int addTeacherProject(Long id, Project project) {
        return jdbcTemplate.update("INSERT INTO projects (id_teacher, project_title, project_description, project_availability) VALUES(id, ?, ?, ?)",
                project.getTeacher().getIdTeacher(), project.getProjectTitle(), project.getProjectDescription(), project.getProjectAvailability());
    }

}
