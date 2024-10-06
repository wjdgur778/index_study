package com.example.demo.Book;

import com.example.demo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.Random;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("books")
    public ResponseEntity<Result> get_books(){
        return ResponseEntity.status(200).body(
                Result.builder()
                        .data(bookService.get_books())
                        .message("ok")
                        .build()
        );
    }
    @GetMapping("add")
    public ResponseEntity<Result> add_books(){

        bookService.add_books();
        return ResponseEntity.status(200).body(
                Result.builder()
                        .data(null)
                        .message("ok")
                        .build()
        );
    }

}
