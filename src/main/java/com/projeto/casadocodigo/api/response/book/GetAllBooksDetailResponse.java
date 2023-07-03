package com.projeto.casadocodigo.api.response.book;

import com.projeto.casadocodigo.api.response.author.AuthorResponse;
import com.projeto.casadocodigo.api.response.category.CategoryResponse;
import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.domain.category.Category;

import java.time.LocalDate;

public class GetAllBooksDetailResponse {
    private Long id;
    private String title;
    private String description;
    private String summary;
    private double price;
    private int numberOfPages;
    private String isbn;
    private LocalDate releaseDate;
    private Category categoryEntity;
    private Author authorEntity;

    public GetAllBooksDetailResponse(Long id, String title, String description, String summary, double price, int numberOfPages, String isbn, LocalDate releaseDate, Category categoryEntity, Author authorEntity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.categoryEntity = categoryEntity;
        this.authorEntity = authorEntity;
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

    public CategoryResponse getCategory() {
        if (categoryEntity != null) {
            return new CategoryResponse(categoryEntity.getName());
        }
        return null;
    }

    public AuthorResponse getAuthor() {
        if (authorEntity != null) {
            return new AuthorResponse(authorEntity.getNome(), authorEntity.getDescricao());
        }
            return null;
        }
    }

