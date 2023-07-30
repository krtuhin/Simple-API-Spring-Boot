package com.api.book.book_api.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.api.book.book_api.entities.Book;

@Service
public class BookService {

    private static ArrayList<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1323, "Math", "A.Sarkar"));
        bookList.add(new Book(54674, "Java", "ABC"));
        bookList.add(new Book(137980, "Python", "XYZ"));
        bookList.add(new Book(8967, "C++", "AABBCC"));
    }

    // method for get all books
    public ArrayList<Book> getAllBooks() {
        return bookList;
    }

    // method for get single book by id
    public Book getBook(int id) {
        Book book = null;

        // like for each loop
        book = bookList.stream().filter(b -> b.getId() == id).findFirst().get();

        return book;
    }

    //method for adding the book
    public void addBook(Book b){
        bookList.add(b);
    }
}
