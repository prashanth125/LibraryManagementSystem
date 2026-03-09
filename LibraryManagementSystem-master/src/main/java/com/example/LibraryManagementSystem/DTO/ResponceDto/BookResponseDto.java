package com.example.LibraryManagementSystem.DTO.ResponceDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookResponseDto {

    private int id;

    private String noOfPages;

    private int price;

    private String authorName;
}
