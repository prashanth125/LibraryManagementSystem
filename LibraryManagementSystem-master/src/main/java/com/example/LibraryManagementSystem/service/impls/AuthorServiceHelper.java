package com.example.LibraryManagementSystem.service.impls;

import com.example.LibraryManagementSystem.DTO.RequestDto.AuthorDTO.AuthorReqDto;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.repository.AuthorRepository;
import com.example.LibraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceHelper implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String add(AuthorReqDto authorReqDto) {

        Author author = new Author();
        author.setName(authorReqDto.getName());
        author.setQualification(authorReqDto.getQualification());
        authorRepository.save(author);
        return "author registered successfully";
    }
}
