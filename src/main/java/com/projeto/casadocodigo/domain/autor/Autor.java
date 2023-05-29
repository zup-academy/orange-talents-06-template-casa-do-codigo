package com.projeto.casadocodigo.domain.autor;

import com.projeto.casadocodigo.gateway.database.model.AutorDatabase;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;


public class Autor {

    private Long id;

    private String nome;

    private String email;

    private String descricao;


    public static Autor fromDatabase(AutorDatabase autorDatabase) {
        return new Autor(autorDatabase.getId(), autorDatabase.getNome(), autorDatabase.getEmail(), autorDatabase.getEmail());
    }

    public Autor(Long id, String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor(String nome, String email, String descricao) {
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
