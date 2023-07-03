package com.projeto.casadocodigo.domain.book;


import com.projeto.casadocodigo.api.response.book.BookResponse;
import com.projeto.casadocodigo.api.response.book.GetAllBooksDetailResponse;
import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.domain.category.Category;
import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import com.projeto.casadocodigo.gateway.database.model.BookDatabase;
import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;

import java.time.LocalDate;

public class Book {
    private Long id;
    private String title;
    private String description;
    private String summary;
    private double price;
    private int numberOfPages;
    private String isbn;
    private LocalDate releaseDate;
    private Long category;
    private Long author;
    private Category categoryEntity;
    private Author authorEntity;

    public Book(Long id, String title, String description, String summary, double price, int numberOfPages, String isbn, LocalDate releaseDate, CategoryDatabase categoryEntity, AuthorDatabase authorEntity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.categoryEntity = Category.fromDataBase(categoryEntity);
        this.authorEntity = Author.fromDatabase(authorEntity);
    }

    public Book(String title, String description, String summary, double price, int numberOfPages, String isbn, LocalDate releaseDate, Long category, Long author) {
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
    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public GetAllBooksDetailResponse getAllBooksDetailResponse() {
        return new GetAllBooksDetailResponse(id, title, description, summary, price, numberOfPages, isbn, releaseDate, categoryEntity, authorEntity);
    }

    public BookResponse toBookResponse() {
        return new BookResponse(id, title);
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

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Category getCategoryEntity() {
        return categoryEntity;
    }

    public Author getAuthorEntity() {
        return authorEntity;
    }
}
