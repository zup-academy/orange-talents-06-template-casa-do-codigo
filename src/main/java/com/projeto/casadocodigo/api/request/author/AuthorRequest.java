package com.projeto.casadocodigo.api.request.Author;

import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.domain.book.Book;
import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import com.projeto.casadocodigo.service.genericValidator.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class AuthorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email(message = "E-mail deve estar em um formato válido")
    @UniqueValue(message = "E-mail deve ser único", fieldName = "email", domainClass = AuthorDatabase.class)
    private String email;
    @NotBlank
    private String descricao;


    public Author toDomain() {
        return new Author(nome, email, descricao);
    }

    public Author toDomain(Long id) {
        return new Author(nome, email, descricao);
    }


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }




}

