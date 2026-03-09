package com.example.LibraryManagementSystem.DTO.RequestDto.AuthorDTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorReqDto {
    private int id;
    private String name;
    private String qualification;
}
