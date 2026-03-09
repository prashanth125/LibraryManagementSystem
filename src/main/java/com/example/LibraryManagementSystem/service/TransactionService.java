package com.example.LibraryManagementSystem.service;


import com.example.LibraryManagementSystem.DTO.RequestDto.TransactionDTO.TransactionReqDto;
import com.example.LibraryManagementSystem.DTO.ResponceDto.TransactionResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    public TransactionResponseDto issueBook(TransactionReqDto transactionReqDto) throws Exception;

    public TransactionResponseDto recoverBook(TransactionReqDto transactionReqDto) throws Exception;
}
