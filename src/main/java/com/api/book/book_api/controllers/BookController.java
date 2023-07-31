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
import java.util.Optional;
import org.springframework.http.ResponseEntity;

//@RestController - used in rest api in place of @Controller
//when use @RestController, don't need @ResponseBody annotation
//@GetMapping - @RequestMapping + RequestMethod.GET
//ResponseEntity - used to send data with http response

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // method for fetch all books
    //return data using response entity
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> list = this.bookService.getAllBooks();

        if (list.size() <= 0) {

            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.of(Optional.of(list));
    }

    // method for get single book using ResponseEntity
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

        Book book = this.bookService.getBook(id);

        if (book == null) {

            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.of(Optional.of(book));
    }

    // @RequestBody - used to auto bind data
    
    // method for create new book
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {

        try {

            this.bookService.addBook(book);

            System.out.println(book);

            return ResponseEntity.of(Optional.of(book));

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.internalServerError().build();
        }
    }

    // method for delete all books
    @DeleteMapping("/books")
    public ResponseEntity<Void> deleteBook() {

        try {

            this.bookService.deleteAllBooks();

            return ResponseEntity.noContent().build();

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.internalServerError().build();
        }
    }

    // method for delete single book
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") int id) {

        try {

            this.bookService.deleteBook(id);

            return ResponseEntity.noContent().build();

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.internalServerError().build();
        }
    }

    // method for update book
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id) {

        try {

            this.bookService.updateBook(book, id);

            return ResponseEntity.ok().body(book);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.internalServerError().build();
        }
    }
}
