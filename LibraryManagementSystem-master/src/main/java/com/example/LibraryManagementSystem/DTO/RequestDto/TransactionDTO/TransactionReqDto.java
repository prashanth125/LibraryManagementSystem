package com.example.LibraryManagementSystem.DTO.RequestDto.TransactionDTO;

import com.example.LibraryManagementSystem.DTO.RequestDto.StudentDTO.StudentGetByIdDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionReqDto {

    private int cardId;

    private int bookId;

}
