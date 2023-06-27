package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.api.response.book.BookResponse;
import com.projeto.casadocodigo.gateway.database.model.BookDatabase;

import java.util.List;

public interface ListAllBooksService {
    List<BookResponse> execute();
}
