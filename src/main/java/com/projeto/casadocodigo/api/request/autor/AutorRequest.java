package com.projeto.casadocodigo.api.request.autor;

import com.projeto.casadocodigo.domain.autor.Autor;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;



public class AutorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String descricao;


    public Autor toDomain() {
        return new Autor(nome, email, descricao);
    }

    public Autor toDomain(Long id) {
        return new Autor(id, nome, email, descricao);
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




}

