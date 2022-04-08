package com.jdbctemplatethesismanagement.controller;

import com.jdbctemplatethesismanagement.entities.dto.TeacherDto;
import com.jdbctemplatethesismanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

   @PostMapping()
    public ResponseEntity<TeacherDto> saveTeacher(@RequestBody TeacherDto teacherDto){
       try{
           teacherService.addTeacher(teacherDto);
           return new ResponseEntity<TeacherDto>(teacherDto, HttpStatus.CREATED);
       } catch(Exception e){
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable("id") Long id, @RequestBody TeacherDto teacherDto){
       if(teacherDto != null) {
           teacherService.updateTeacher(id, teacherDto);
           return new ResponseEntity<TeacherDto>(teacherDto, HttpStatus.OK);
       }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") Long id) {
           int result = teacherService.deleteById(id);
           if (result == 0) {
               return new ResponseEntity<>("Cannot find Teacher with id = " + id, HttpStatus.NOT_FOUND);
           }
           return new ResponseEntity<>("Teacher deleted successfully.", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable("id") Long id){
       TeacherDto teacherDto = teacherService.findById(id);
       if(teacherDto != null){
           return new ResponseEntity<>(teacherDto, HttpStatus.OK);
       } else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping()
    public ResponseEntity<List<TeacherDto>> getAllTeachers(){
        List<TeacherDto> teacherDtoList = teacherService.findAll();
        return new ResponseEntity<>(teacherDtoList, HttpStatus.OK);
    }





}
