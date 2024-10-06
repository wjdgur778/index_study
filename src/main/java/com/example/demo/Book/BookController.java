package com.example.demo.Book;

import com.example.demo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/title/{title}")
    public ResponseEntity<Result> getByTitle(@PathVariable("title") String title){
        return ResponseEntity.status(200).body(
                Result.builder()
                        .data(bookService.getByTitle(title))
                        .message("ok")
                        .build()
        );
    }
    @GetMapping("/author/{author}")
    public ResponseEntity<Result> getByAuthor(@PathVariable("author") String author){
        return ResponseEntity.status(200).body(
                Result.builder()
                        .data(bookService.getByAuthor(author))
                        .message("ok")
                        .build()
        );
    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity<Result> getByGenre(@PathVariable("genre") String genre){
        return ResponseEntity.status(200).body(
                Result.builder()
                        .data(bookService.getByGenre(genre))
                        .message("ok")
                        .build()
        );
    }

    @GetMapping("/add_books")
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
