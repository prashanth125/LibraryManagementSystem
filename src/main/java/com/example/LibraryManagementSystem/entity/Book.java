package com.example.LibraryManagementSystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String noOfPages;

    private int price;

    private boolean issueStatus;

    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    Card card;

    @OneToMany(mappedBy = "book",cascade=CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();
}
