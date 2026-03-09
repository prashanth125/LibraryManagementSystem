package com.example.LibraryManagementSystem.service;


import com.example.LibraryManagementSystem.DTO.RequestDto.AuthorDTO.AuthorReqDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    public String add(AuthorReqDto authorReqDto);

}

