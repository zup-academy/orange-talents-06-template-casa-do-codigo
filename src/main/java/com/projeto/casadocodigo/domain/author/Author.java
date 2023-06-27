package com.projeto.casadocodigo.domain.author;

import com.projeto.casadocodigo.domain.book.Book;
import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Author {

    private Long id;

    private String nome;

    private String email;

    private String descricao;

    public Author(){

    }

    public static Author fromDatabase(AuthorDatabase authorDatabase) {
        return new Author(authorDatabase.getId(), authorDatabase.getNome(), authorDatabase.getEmail(), authorDatabase.getDescricao());
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
