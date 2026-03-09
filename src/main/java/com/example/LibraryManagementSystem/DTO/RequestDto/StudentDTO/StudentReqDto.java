package com.example.LibraryManagementSystem.DTO.RequestDto.StudentDTO;


import com.example.LibraryManagementSystem.enums.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentReqDto {

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;
    private String mobNo;
    private String email;
}
