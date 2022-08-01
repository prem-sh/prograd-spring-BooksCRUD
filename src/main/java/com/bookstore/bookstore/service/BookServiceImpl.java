package com.bookstore.bookstore.service;

import com.bookstore.bookstore.models.Book;
import com.bookstore.bookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepo bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return bookRepo.findById(id);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return bookRepo.findAllByTitle(title);
    }

    @Override
    public List<Book> getBooksByPriceRange(Double from, Double to) {
//        return bookRepo.findAllByPriceRange(from, to);
        return bookRepo.findAllByPriceRange(from, to);

    }


    @Override
    public List<Book> getBooksByCategories(String category) {
        return bookRepo.findAllByCategory(category);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepo.findAllByAuthor(author);
    }

//    @Override
//    public List<Book> getAllCategories() {
//        return bookRepo.findAllCategories();
//    }
//
//    @Override
//    public List<Book> getAllAuthors() {
//        return bookRepo.findAllAuthors();
//    }
//
//    @Override
//    public List<Book> getAllTitle() {
//        return bookRepo.findAllTitle();
//    }

    @Override
    public String addBook(Book book) {
        bookRepo.save(book);
        return "New book added successfully";
    }

    @Override
    public String deleteBook(Integer id) {
        if(bookRepo.findById(id).isPresent()){
            bookRepo.deleteById(id);
        }else {
            return "Book not found";
        }
        return "Book Deleted Successfully";
    }

    @Override
    public String updateBook(Integer id, Book book) {
        Optional<Book> search = bookRepo.findById(id);
        if(search.isPresent()){
            Book bookEntity = (Book) search.get();
            if(book.getTitle() != null) bookEntity.setTitle(book.getTitle());
            if(book.getPrice() != null) bookEntity.setPrice(book.getPrice());
            if(book.getAuthor() != null) bookEntity.setAuthor(book.getAuthor());
            if(book.getCategory() != null) bookEntity.setCategory(book.getCategory());
            if(book.getDescription() != null) bookEntity.setDescription(book.getDescription());
            bookRepo.save(bookEntity);
        }else {
            return "Book not found and not updated";
        }
        return "Book Updated Successfully";
    }
}
