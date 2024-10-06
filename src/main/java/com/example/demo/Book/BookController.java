package com.example.demo.Book;

import com.example.demo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("use_index")
    public ResponseEntity<Result> get_books(){
        return ResponseEntity.status(200).body(
                Result.builder()
                        .data(null)
                        .message("ok")
                        .build()
        );


    }
}
