package com.projeto.casadocodigo.gateway.database.model;

import com.projeto.casadocodigo.domain.author.Author;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class AuthorDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "descricao", nullable = false, length = 400)
    private String descricao;

    @Column(name = "instanteAuthor", nullable = false)
    @CreationTimestamp
    private LocalDateTime instanteAuthor;

    @OneToMany(mappedBy = "author")
    private List<BookDatabase> books;

    public AuthorDatabase(){

    }
    public AuthorDatabase(Long id) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public AuthorDatabase(Author author) {
        this.nome = author.getNome();
        this.email = author.getEmail();
        this.descricao = author.getDescricao();
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

    public LocalDateTime getInstanteAuthor() {
        return instanteAuthor;
    }

    public List<BookDatabase> getBooks() {
        return books;
    }

}

