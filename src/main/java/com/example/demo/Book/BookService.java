package com.example.demo.Book;

import com.example.demo.Book.dto.ResponseBooks;
import com.example.demo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public List<ResponseBooks> get_books() {
        return bookRepository.findAll().stream().map(
                book -> new ResponseBooks(book.getTitle(), book.getAuthor(), book.getPublicshedYear(), book.getGenre())
        ).collect(Collectors.toList());
    }
}
