package com.projeto.casadocodigo.api.request.book;

import com.projeto.casadocodigo.domain.book.Book;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class BookRequest {
    @NotBlank
    private String title;
    @NotBlank
    @Length(max = 500, message = "Tamanho máximo de palavras atingido")
    private String description;
    private String summary;
    @NotNull
    @Min(value = 20, message = "O preço minímo deve ser de 20")
    private double price;
    @NotNull(message = "O número de páginas é obrigatório")
    @Min(value = 100, message = "O livro deve ter no mínimo 100 páginas")
    private Integer numberOfPages;

    @NotBlank
    private String isbn;
    @Future(message = "A data de lançamento deve ser futura")
    private LocalDate releaseDate;
    @NotNull
    private Long category;
    @NotNull
    private Long author;

//    public Book toDomain(Long id){
//        return new Book(id, title, description, summary, price, numberOfPages, isbn, releaseDate, category, author);
//    }
    public Book toDomain(){
        return new Book(title, description, summary, price, numberOfPages, isbn, releaseDate, category, author);
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

    public Integer getNumberOfPages() {
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

    public Long getAuthor() {
        return author;
    }
}
