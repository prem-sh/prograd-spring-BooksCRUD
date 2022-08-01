package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.models.Book;
import com.bookstore.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController{
    @Autowired
    BookService service;
    @GetMapping
    public List<Book> getBooks(){
        return service.getAllBooks();
    }
    @GetMapping("{title}")
    public List<Book> getBooks(@PathVariable String title){
        return service.getBookByTitle(title);
    }
    @GetMapping("author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author){
        return service.getBooksByAuthor(author);
    }
    @GetMapping("category/{category}")
    public List<Book> getBooksByCategory(@PathVariable String category){
        return service.getBooksByCategories(category);
    }
    @GetMapping("price")
    public List<Book> getBooksByPriceRange(@RequestParam(name="from") Double from, @RequestParam(name="to") Double to){
        return service.getBooksByPriceRange(from, to);
    }
    @PostMapping
    public ResponseEntity<String> postBook(@RequestBody Book book){
        return new ResponseEntity<String>(service.addBook(book),HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        return new ResponseEntity<String>(service.deleteBook(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateBook(@PathVariable Integer id, @RequestBody Book book){
        return new ResponseEntity<String>(service.updateBook(id, book),HttpStatus.OK);
    }
}
