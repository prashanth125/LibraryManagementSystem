package com.example.LibraryManagementSystem.controller;


import com.example.LibraryManagementSystem.DTO.RequestDto.AuthorDTO.AuthorReqDto;
import com.example.LibraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {


    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody AuthorReqDto authorReqDto){
        String ans = authorService.add(authorReqDto);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
}
