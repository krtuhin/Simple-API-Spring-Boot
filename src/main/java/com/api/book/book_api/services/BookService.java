package com.api.book.book_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.book_api.entities.Book;

@Service
public class BookService {

    private static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1323, "Math", "A.Sarkar"));
        bookList.add(new Book(54674, "Java", "ABC"));
        bookList.add(new Book(137980, "Python", "XYZ"));
        bookList.add(new Book(8967, "C++", "AABBCC"));
    }

    // method for get all books
    public List<Book> getAllBooks() {
        return bookList;
    }

    // method for get single book by id
    public Book getBook(int id) {
        Book book = null;

        //when book is null
        try {
            // like for each loop
            book = bookList.stream().filter(b -> b.getId() == id).findFirst().get();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return book;
    }

    // method for adding the book
    public void addBook(Book b) {
        bookList.add(b);
    }

    // method for delete all books
    public void deleteAllBooks() {
        bookList.removeAll(bookList);
    }

    // method for delete single book by id
    public void deleteBook(int id) {

        // Book book = null;
        // book = bookList.stream().filter(u -> u.getId() == id).findFirst().get();
        // bookList.remove(book);
        bookList = bookList.stream().filter(b -> b.getId() != id).collect(Collectors.toList());
    }

    // method for update book
    public void updateBook(Book book, int id) {

        // update book details
        bookList = bookList.stream().map(b -> {
            if (b.getId() == id) {

                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;

        }).collect(Collectors.toList());
    }
}
