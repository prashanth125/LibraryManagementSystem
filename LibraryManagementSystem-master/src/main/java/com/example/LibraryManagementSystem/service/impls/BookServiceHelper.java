package com.example.LibraryManagementSystem.service.impls;

import com.example.LibraryManagementSystem.DTO.RequestDto.BookDTO.BookReqDto;
import com.example.LibraryManagementSystem.DTO.ResponceDto.BookResponseDto;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.repository.AuthorRepository;
import com.example.LibraryManagementSystem.repository.BookRepository;
import com.example.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceHelper implements BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public String add(BookReqDto bookReqDto) throws Exception {
        Optional<Author> optionalAuthor = authorRepository.findById(bookReqDto.getAuthorReqDto().getId());
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            Book book = new Book();
            book.setNoOfPages(bookReqDto.getNoOfPages());
            book.setPrice(bookReqDto.getPrice());
            book.setAuthor(author);
            author.getBooks().add(book);
            authorRepository.save(author);
        } else {
            throw new RuntimeException("Author with ID not found");
        }
        return "Book added successfully";
    }

    @Override
    public List<BookResponseDto> getAlLBooksByAuthorId(int id) {
        List<Book> bookList = authorRepository.findById(id).get().getBooks();
        List<BookResponseDto> list = new ArrayList<>();
        for(Book book:bookList){
            try{
                if(book.getAuthor().getId() == id){
                    BookResponseDto bookResponseDto = new BookResponseDto();
                    bookResponseDto.setAuthorName(book.getAuthor().getName());
                    bookResponseDto.setPrice(book.getPrice());
                    bookResponseDto.setId(book.getId());
                    bookResponseDto.setNoOfPages(book.getNoOfPages());
                    list.add(bookResponseDto);
                }
            }catch (Exception e){

            }
        }
        return list;
    }
}
