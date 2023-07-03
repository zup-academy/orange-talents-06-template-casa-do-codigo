package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.api.response.book.BookResponse;

import java.util.List;

public interface GetAllBooksService {
    List<BookResponse> execute();
}
