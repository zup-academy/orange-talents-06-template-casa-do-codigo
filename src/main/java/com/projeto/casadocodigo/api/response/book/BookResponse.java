package com.projeto.casadocodigo.api.response.book;

public class BookResponse {
    private Long id;
    private String title;

    public BookResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
