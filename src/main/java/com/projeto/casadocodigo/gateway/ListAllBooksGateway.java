package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.api.response.book.BookResponse;
import com.projeto.casadocodigo.gateway.database.model.BookDatabase;

import java.util.List;

public interface ListAllBooksGateway {
    List<BookResponse> execute();
}
