package com.projeto.casadocodigo.domain.Author;

import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;


public class Author {

    private Long id;

    private String nome;

    private String email;

    private String descricao;


    public static Author fromDatabase(AuthorDatabase AuthorDatabase) {
        return new Author(AuthorDatabase.getId(), AuthorDatabase.getNome(), AuthorDatabase.getEmail(), AuthorDatabase.getEmail());
    }

    public Author(Long id, String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Author(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;

    }

    public Long getId() {
        return id;
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
