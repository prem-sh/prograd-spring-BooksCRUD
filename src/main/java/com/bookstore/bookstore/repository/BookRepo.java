package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
    @Query("select u from Book u where u.title=?1")
    List<Book> findAllByTitle(String title);
    @Query("select u from Book u where u.author=?1")
    List<Book>  findAllByAuthor(String author);
    @Query("select u from Book u where u.category=?1")
    List<Book>  findAllByCategory(String category);
    @Query("select u from Book u where u.price between ?1 and ?2")
    List<Book> findAllByPriceRange(Double mt, Double lt);
}
