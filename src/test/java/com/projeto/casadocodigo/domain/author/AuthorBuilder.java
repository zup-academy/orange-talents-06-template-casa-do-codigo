package com.projeto.casadocodigo.domain.author;

public class AuthorBuilder {
    private String nome;

    private String email;

    private String descricao;

    private AuthorBuilder() {
    }

    public static AuthorBuilder anAuthor() {
        AuthorBuilder builder = new AuthorBuilder();
        inicializadorDadosPadrao(builder);
        return builder;
    }

    private static void inicializadorDadosPadrao(AuthorBuilder builder) {
        builder.nome = "Usuario Válido";
        builder.email = "usuariovalido@gmail.com";
        builder.descricao = "Criador do livro programação para todos";
    }

    public AuthorBuilder withName(String param) {
        nome = param;
        return this;
    }

    public AuthorBuilder withEmail(String param) {
        email = param;
        return this;
    }

    public AuthorBuilder withDescription(String param) {
        descricao = param;
        return this;
    }

    public Author build(){
        return new Author(nome, email, descricao);
    }
}
