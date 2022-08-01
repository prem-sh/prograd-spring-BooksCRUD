package com.bookstore.bookstore.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column
    private String category;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private Double price;
}
