package com.example.LibraryManagementSystem.controller;


import com.example.LibraryManagementSystem.DTO.RequestDto.TransactionDTO.TransactionReqDto;
import com.example.LibraryManagementSystem.DTO.ResponceDto.TransactionResponseDto;
import com.example.LibraryManagementSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @PostMapping("/take")
    public ResponseEntity<TransactionResponseDto> issueBook(@RequestBody TransactionReqDto transactionReqDto) throws Exception {
        return new ResponseEntity<TransactionResponseDto>(transactionService.issueBook(transactionReqDto), HttpStatus.OK);
    }

    @PostMapping("/return")
    public ResponseEntity<TransactionResponseDto> recoverBook(@RequestBody TransactionReqDto transactionReqDto) throws Exception {
        return new ResponseEntity<TransactionResponseDto>(transactionService.recoverBook(transactionReqDto), HttpStatus.OK);
    }

}
