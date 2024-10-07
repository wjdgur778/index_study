package com.example.demo.Book;

import com.example.demo.Book.dto.ResponseBooks;
import com.example.demo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    String[] str = {"novel","SF","romance","thriller","history"};
    @Transactional
    public ResponseBooks getByTitle(String title) {
        Book book = bookRepository.findByTitle(title).orElse(null);
        return new ResponseBooks(book.getTitle(),book.getAuthor(),book.getPublicshedYear(),book.getGenre());
    }
    @Transactional
    public ResponseBooks getByAuthor(String author) {
        Book book = bookRepository.findByAuthor(author).orElse(null);
        return new ResponseBooks(book.getTitle(),book.getAuthor(),book.getPublicshedYear(),book.getGenre());
    }
    @Transactional
    public List<ResponseBooks> getByGenre(String genre) {
        return bookRepository.findByGenre(genre).stream().map(
               book ->  new ResponseBooks(book.getTitle(),book.getAuthor(),book.getPublicshedYear(),book.getGenre())
        ).collect(Collectors.toList());
    }

    @Transactional
    public void add_books() {
        Random r = new Random();
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            books.add(new Book(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 2014+(r.nextInt()%20),str[Math.abs(r.nextInt())%4]));
        }
        bookRepository.saveAll(books);
    }
}
