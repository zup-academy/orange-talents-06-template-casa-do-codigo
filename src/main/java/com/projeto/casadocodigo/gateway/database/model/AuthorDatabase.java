package com.projeto.casadocodigo.gateway.database.model;

import com.projeto.casadocodigo.domain.Author.Author;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

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

    public AuthorDatabase() {
        // Construtor vazio necessário para o JPA
    }
    public AuthorDatabase(Long id, String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;

    }

    public static AuthorDatabase model(Author Author) {
        return new AuthorDatabase(Author.getId(), Author.getNome(), Author.getEmail(), Author.getDescricao());
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


}

