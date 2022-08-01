package com.bookstore.bookstore.service;

import com.bookstore.bookstore.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(Integer id);
    List<Book> getBookByTitle(String title);
    List<Book> getBooksByPriceRange(Double from, Double to);
    List<Book> getBooksByCategories(String category);
    List<Book> getBooksByAuthor(String author);
    String addBook(Book book);
    String deleteBook(Integer id);
    String updateBook(Integer id, Book Book);
}
