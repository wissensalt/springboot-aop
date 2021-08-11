package com.wissensalt.sbaop.service;

import com.wissensalt.sbaop.Book;
import com.wissensalt.sbaop.aop.ExecutionTimeTracker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookService  {

    @ExecutionTimeTracker
    public List<Book> saveBook(List<Book> books, String bookName) {
        Book book = new Book();
        book.setId(books.size() + 1L);
        book.setName(bookName);
        books.add(book);

        return books;
    }

    @ExecutionTimeTracker
    public List<Book> deleteBook(List<Book> books, Long id) {
        return books.stream()
                .filter(book -> !book.getId().equals(id))
                .collect(Collectors.toList());
    }

    public Book findBookById(List<Book> books, Long id) throws Exception {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Book Not Found"));
    }

    public void printBooks(List<Book> books) {
        books.forEach(book -> log.info(book.toString()));
    }
}
