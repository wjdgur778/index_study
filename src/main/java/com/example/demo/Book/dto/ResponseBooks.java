package com.example.demo.Book.dto;

import com.example.demo.Book.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseBooks {
    String title;
    String author;
    int publicshedYear;
    String genre;
}
