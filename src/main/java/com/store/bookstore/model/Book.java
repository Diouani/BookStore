package com.store.bookstore.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title" , nullable = false , length = 100)
    private String title;

    @Column(name = "description" , nullable = false , length = 100)
    private String description;

    @Column(name = "author" , nullable = false , length = 50)
    private String author;

    @Column(name = "price" , nullable = false , length = 10)
    private Double price;

    @Column(name ="created_at"  , nullable = false)
    private LocalDateTime createTime;
}
