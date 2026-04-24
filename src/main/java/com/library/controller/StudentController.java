package com.library.controller;

import com.library.dto.StudentDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("student")
public class StudentController {
    List<StudentDto> students = new ArrayList<>();

    @PostMapping("/create")
    public StudentDto createStudent(@RequestBody StudentDto dto){
        dto.setId(UUID.randomUUID().toString());
        dto.setCreatedDate(LocalDateTime.now());
        students.add(dto);
        return dto;
    }

    @GetMapping("/list")
    public List<StudentDto> getStudentList(){
        return students;
    }

    @GetMapping("by-id/{id}")
    public StudentDto getStudentById(@PathVariable String id){
        for(StudentDto dto :students){
            if(dto.getId().equals(id)) return dto;
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteStudent(@PathVariable String id){
        return students.removeIf(dto -> dto.getId().equals(id));
    }

    @PutMapping("/update/{id}")
    public Boolean updateStudent(@PathVariable String id, @RequestBody StudentDto newDto){
        for(StudentDto dto :students){
            if(dto.getId().equals(id)){
                dto.setName(newDto.getName());
                dto.setSurname(newDto.getSurname());
                dto.setPhone(newDto.getPhone());
                return true;
            }
        }
        return false;
    }






}