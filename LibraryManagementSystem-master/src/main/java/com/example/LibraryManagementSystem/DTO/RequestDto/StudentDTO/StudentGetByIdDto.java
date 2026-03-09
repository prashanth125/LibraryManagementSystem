package com.example.LibraryManagementSystem.DTO.RequestDto.StudentDTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentGetByIdDto {
    int id;
    String name;
}
