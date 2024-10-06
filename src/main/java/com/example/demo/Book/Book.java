package com.example.demo.Book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
@Table(name = "books", indexes = {
        @Index(name = "idx_title", columnList = "title"),
        @Index(name = "idx_author", columnList = "author")
})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private int publicshedYear;
    private String genre;

    public Book(String title, String author,int publicshedYear,String genre){
        this.title = title;
        this.author = author;
        this.publicshedYear = publicshedYear;
        this.genre = genre;
    }

}
