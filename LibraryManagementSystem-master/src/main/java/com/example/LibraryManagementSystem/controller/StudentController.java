package com.example.LibraryManagementSystem.controller;


import com.example.LibraryManagementSystem.DTO.RequestDto.StudentDTO.StudentGetByIdDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.StudentDTO.StudentReqDto;
import com.example.LibraryManagementSystem.DTO.ResponceDto.StudentResponseDto;
import com.example.LibraryManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody StudentReqDto studentReqDto) {

        String response = studentService.add(studentReqDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update-number")
    public ResponseEntity<String> updateMobileNumber(@RequestParam("mobNo")String mobNo,
                                                     @RequestParam("id")int id){

        String ans = studentService.updateMobileNumber(mobNo,id);

        return new ResponseEntity<String>(ans,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        List<StudentResponseDto> list= studentService.getAllStudents();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @DeleteMapping("/delete-by-id")
    public String deleteStudentById(@RequestBody StudentGetByIdDto studentGetByIdDto){
        return studentService.deleteById(studentGetByIdDto);
    }


}
