package com.example.LibraryManagementSystem.service.impls;


import com.example.LibraryManagementSystem.DTO.RequestDto.TransactionDTO.TransactionReqDto;
import com.example.LibraryManagementSystem.DTO.ResponceDto.TransactionResponseDto;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.entity.Card;
import com.example.LibraryManagementSystem.entity.Transaction;
import com.example.LibraryManagementSystem.enums.Status;
import com.example.LibraryManagementSystem.enums.TransactionStatus;
import com.example.LibraryManagementSystem.repository.BookRepository;
import com.example.LibraryManagementSystem.repository.CardRepository;
import com.example.LibraryManagementSystem.repository.TransactionRepository;
import com.example.LibraryManagementSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceHelper implements TransactionService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public TransactionResponseDto issueBook(TransactionReqDto transactionReqDto) throws Exception {
        Transaction transaction = new Transaction();
        Book book;
        transaction.setTransactionNumber(UUID.randomUUID().toString());
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        Optional<Card> optionalCard = cardRepository.findById(transactionReqDto.getCardId());
        if(optionalCard.isPresent()){
            Card card = optionalCard.get();
            transaction.setCard(card);
            Optional<Book> optionalBook = bookRepository.findById(transactionReqDto.getBookId());
            if(optionalBook.isPresent()){
                book = optionalBook.get();
                transaction.setBook(book);
                if(book.isIssueStatus()){
                    transaction.setTransactionStatus(TransactionStatus.FAILED);
                    transactionRepository.save(transaction);
                    throw new ClassNotFoundException("Book is not available at the moment");
                }
            }
            else{
                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transactionRepository.save(transaction);
                throw new ClassNotFoundException("Book not Found");
            }
            if(card.getStatus()== Status.ACTIVATED){
                transaction.setTransactionStatus(TransactionStatus.SUCCESS);

                card.getBookList().add(book);
                card.getTransactionList().add(transaction);

                book.setCard(card);
                book.setIssueStatus(true);
                book.getTransactionList().add(transaction);

                transaction.setIssued(true);

                cardRepository.save(card);
              //  transactionRepository.save(transaction);

                TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
                transactionResponseDto.setTransactionNumber(transaction.getTransactionNumber());
                transactionResponseDto.setBookName(book.getAuthor().getName());
                transactionResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
                return transactionResponseDto;
            }
            else{
                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transactionRepository.save(transaction);
                throw new ClassNotFoundException("Your card is inactive please connect with management");
            }
        }else{
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new ClassNotFoundException("Invalid card Id ");
        }
    }

    @Override
    public TransactionResponseDto recoverBook(TransactionReqDto transactionReqDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setTransactionNumber(UUID.randomUUID().toString());
        Card card;
        try{
            card = cardRepository.findById(transactionReqDto.getCardId()).get();
        }catch (Exception e){
            throw new Exception("card not found");
        }
        transaction.setCard(card);
        Book book;
        try{
            book = bookRepository.findById(transactionReqDto.getBookId()).get();
        }catch (Exception e){
            throw new Exception("book not found");
        }
        transaction.setBook(book);
        if(!book.isIssueStatus() || !card.getBookList().contains(book)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new ClassNotFoundException("Book was not issued on this book");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssueStatus(false);
        book.setCard(null);
        book.getTransactionList().add(transaction);


        card.getBookList().remove(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card); // save card, book, and transaction.

        // Prepare response dto;
        TransactionResponseDto returnBookResponseDto = new TransactionResponseDto();
        returnBookResponseDto.setBookName(book.getAuthor().getName());
        returnBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        returnBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());
        return returnBookResponseDto;
    }
}
