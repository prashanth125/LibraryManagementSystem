package com.example.LibraryManagementSystem.entity;


import com.example.LibraryManagementSystem.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String validTill;

    @CreationTimestamp
    private Date issueDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> bookList = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade=CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();
}
