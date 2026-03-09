package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.DTO.RequestDto.StudentDTO.StudentGetByIdDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.StudentDTO.StudentReqDto;
import com.example.LibraryManagementSystem.DTO.ResponceDto.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {

    public String add(StudentReqDto studentReqDto);

    public String updateMobileNumber(String mobNo,int id);

    public List<StudentResponseDto> getAllStudents();

    String deleteById(StudentGetByIdDto studentGetByIdDto);
}
