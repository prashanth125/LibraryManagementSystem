package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.DTO.RequestDto.BookDTO.BookReqDto;
import com.example.LibraryManagementSystem.DTO.ResponceDto.BookResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public String add(BookReqDto bookReqDto) throws Exception;

    public List<BookResponseDto> getAlLBooksByAuthorId(int id);
}

