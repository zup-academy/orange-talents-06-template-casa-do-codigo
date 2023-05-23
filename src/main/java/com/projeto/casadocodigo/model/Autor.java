package com.projeto.casadocodigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Entity
@EnableJpaAuditing
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;
    @NotBlank
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @NotBlank
    @Size(max = 400)
    @Column(name = "descricao", nullable = false)
    private String descricao;


    @CreationTimestamp
    @Column(name = "instanteAutor", nullable = false)
    private LocalDateTime instanteAutor;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getInstanteAutor() {
        return instanteAutor;
    }


}
