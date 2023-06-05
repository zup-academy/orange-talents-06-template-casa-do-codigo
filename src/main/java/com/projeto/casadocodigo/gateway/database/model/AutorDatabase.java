package com.projeto.casadocodigo.gateway.database.model;

import com.projeto.casadocodigo.domain.autor.Autor;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
public class AutorDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "descricao", nullable = false, length = 400)
    private String descricao;

    @Column(name = "instanteAutor", nullable = false)
    @CreationTimestamp
    private LocalDateTime instanteAutor;

    public AutorDatabase() {
        // Construtor vazio necessário para o JPA
    }
    public AutorDatabase(Long id, String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;

    }

    public static AutorDatabase model(Autor autor) {
        return new AutorDatabase(autor.getId(), autor.getNome(), autor.getEmail(), autor.getDescricao());
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

    public LocalDateTime getInstanteAutor() {
        return instanteAutor;
    }


}

