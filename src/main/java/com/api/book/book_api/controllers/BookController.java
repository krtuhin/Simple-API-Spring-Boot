package com.api.book.book_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.book_api.entities.Book;
import com.api.book.book_api.services.BookService;

//@RestController - used in rest api in place of @Controller
//when use @RestController, don't need @ResponseBody annotation
//@GetMapping - @RequestMapping + RequestMethod.GET

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // method for fetch all books
    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    // method for get single book
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return this.bookService.getBook(id);
    }

    // @RequestBody - used to auto bind data

    // method for create new book
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {

        this.bookService.addBook(book);

        System.out.println(book);

        return book;
    }

    // method for delete all books
    @DeleteMapping("/books")
    public void deleteBook() {
        this.bookService.deleteAllBooks();
    }

    // method for delete single book
    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable("id") int id) {
        this.bookService.deleteBook(id);
    }

    // method for update book
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {

        this.bookService.updateBook(book, id);

        return book;
    }
}