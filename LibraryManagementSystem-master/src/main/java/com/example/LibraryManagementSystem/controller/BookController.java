package com.example.LibraryManagementSystem.controller;


import com.example.LibraryManagementSystem.DTO.RequestDto.BookDTO.BookReqDto;
import com.example.LibraryManagementSystem.DTO.ResponceDto.BookResponseDto;
import com.example.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody BookReqDto bookReqDto) throws Exception {
        String ans = bookService.add(bookReqDto);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-booksBy-authorId")
    public ResponseEntity<List<BookResponseDto>> getAlLBooksByAuthorId(@RequestParam("id") int id){

        return new ResponseEntity<>(bookService.getAlLBooksByAuthorId(id),HttpStatus.OK);
    }

}
