package com.example.demo.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByTitle(String title);
    Optional<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);
}
