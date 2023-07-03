package com.projeto.casadocodigo.gateway.database.model;


import com.projeto.casadocodigo.api.response.book.GetAllBooksDetailResponse;
import com.projeto.casadocodigo.domain.book.Book;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BookDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", unique = true, nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "summary", nullable = false)
    private String summary;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "numberOfPages", nullable = false)
    private int numberOfPages;
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;
    @Column(name = "releaseDate", nullable = false)
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryDatabase category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorDatabase author;

    public BookDatabase(){

    }

    public BookDatabase(Book book) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.category = category;
        this.author = author;
    }

    public Book toBookResponse(){
        return new Book(id, title, description, summary, price, numberOfPages,
        isbn, releaseDate, category, author);
    }
    public Book toBook(){
        return new Book(id,title);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public CategoryDatabase getCategory() {
        return category;
    }

    public AuthorDatabase getAuthor() {
        return author;
    }


}
