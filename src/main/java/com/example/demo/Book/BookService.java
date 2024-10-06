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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final Random r;
    String[] str = {"novel,SF,romance,thriller,history"};
    @Transactional
    public List<ResponseBooks> get_books() {
        return bookRepository.findAll().stream().map(
                book -> new ResponseBooks(book.getTitle(), book.getAuthor(), book.getPublicshedYear(), book.getGenre())
        ).collect(Collectors.toList());
    }
    @Transactional
    public void add_books() {

        List<Book> books = new ArrayList<>();
        Random r = new Random();
        byte[] t_data = new byte[7];
        byte[] a_data = new byte[7];
        r.nextBytes(t_data);
        r.nextBytes(a_data);
        String title = new String(t_data, Charset.forName("UTF-8"));
        String author = new String(a_data, Charset.forName("UTF-8"));
        for (int i = 0; i < 30000; i++) {
            books.add(new Book(title, author, 2014+(r.nextInt()%20),str[r.nextInt()%5]));
        }
        bookRepository.saveAll(books);
    }
}
