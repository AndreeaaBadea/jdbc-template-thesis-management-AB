package com.jdbctemplatethesismanagement.service;

import com.jdbctemplatethesismanagement.entities.Teacher;
import com.jdbctemplatethesismanagement.entities.dto.ProjectDto;
import com.jdbctemplatethesismanagement.entities.dto.TeacherDto;
import com.jdbctemplatethesismanagement.repository.JdbcTeacherRepository;
import com.jdbctemplatethesismanagement.service.mapper.ProjectMapper;
import com.jdbctemplatethesismanagement.service.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private JdbcTeacherRepository jdbcTeacherRepository;

    public int addTeacher(TeacherDto teacherDto){
      int result = jdbcTeacherRepository.save(TeacherMapper.teacherDtoToTeacher(teacherDto));
      Logger.info("Teacher id {} saved to database.", teacherDto.getIdTeacher());
      return result;
    }

    public int updateTeacher(Long id, TeacherDto teacherDto){
        Teacher existingTeacher = jdbcTeacherRepository.findById(id);
        teacherDto.setIdTeacher(id);
        teacherDto.setFirstName(existingTeacher.getFirstName());
        teacherDto.setLastName(existingTeacher.getLastName());
        teacherDto.setEmail(existingTeacher.getEmail());
        teacherDto.setCNP(existingTeacher.getCNP());
        teacherDto.setNumberOfStudents(existingTeacher.getNumberOfStudents());
        int result = jdbcTeacherRepository.update(TeacherMapper.teacherDtoToTeacher(teacherDto));
        Logger.info("Teacher id {} updated.", id);
        return result;
    }

     public TeacherDto findById(Long id){
        return TeacherMapper.teacherToTeacherDto(jdbcTeacherRepository.findById(id));
     }

     public int deleteById(Long id){
        int result = jdbcTeacherRepository.deleteById(id);
        Logger.info("Teacher id {} deleted from database.", id);
        return result;
     }

     public List<TeacherDto> findAll(){
        return jdbcTeacherRepository.findAll().stream().map(TeacherMapper::teacherToTeacherDto).collect(Collectors.toList());
     }

     public int addTeacherProject(Long id, ProjectDto projectDto){
        int result = jdbcTeacherRepository.addTeacherProject(id, ProjectMapper.projectDtoToProject(projectDto));
        Logger.info("Teacher id {} added project id {}.", id, projectDto.getIdProject());
        return result;
     }





}
