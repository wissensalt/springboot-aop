package com.wissensalt.sbaop;

import com.wissensalt.sbaop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringbootAopApplication implements CommandLineRunner {

    private final BookService bookService;

    public static void main(String[] args) {
      SpringApplication.run(SpringbootAopApplication.class);
  }

    @Override
    public void run(String... args) throws Exception {
        List<Book> books = new ArrayList<>();
        books = bookService.saveBook(books, "Book 1");
        books = bookService.saveBook(books, "Book 2");
        books = bookService.saveBook(books, "Book 3");
        bookService.printBooks(books);
        bookService.findBookById(books, 2L);
        bookService.findBookById(books, 4L);
        bookService.deleteBook(books, 3L);
        bookService.printBooks(books);
    }
}
