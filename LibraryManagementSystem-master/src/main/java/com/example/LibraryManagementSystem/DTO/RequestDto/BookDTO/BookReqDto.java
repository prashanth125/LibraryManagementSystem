package com.example.LibraryManagementSystem.DTO.RequestDto.BookDTO;

import com.example.LibraryManagementSystem.DTO.RequestDto.AuthorDTO.AuthorReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookReqDto {


    private String noOfPages;

    private int price;

    private AuthorReqDto authorReqDto;

}
