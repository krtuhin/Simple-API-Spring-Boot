package com.api.book.book_api.dao;

import com.api.book.book_api.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    public Book findById(int id);

}
