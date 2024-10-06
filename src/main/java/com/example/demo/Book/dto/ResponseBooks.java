package com.example.demo.Book.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseBooks {
    private String title;
    private String author;
    private int publicshedYear;
    private String genre;
}
