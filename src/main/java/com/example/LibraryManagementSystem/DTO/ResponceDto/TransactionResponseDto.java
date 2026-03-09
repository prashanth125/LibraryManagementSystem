package com.example.LibraryManagementSystem.DTO.ResponceDto;


import com.example.LibraryManagementSystem.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionResponseDto {

    private String transactionNumber;

    private TransactionStatus transactionStatus;

    private String bookName;
}
