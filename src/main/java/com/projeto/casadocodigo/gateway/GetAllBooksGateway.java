package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.api.response.book.BookResponse;

import java.util.List;

public interface GetAllBooksGateway {
    List<BookResponse> execute();
}
