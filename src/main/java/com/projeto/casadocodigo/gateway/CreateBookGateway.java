package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.domain.book.Book;
import com.projeto.casadocodigo.gateway.exception.CreateBookGatewayException;

public interface CreateBookGateway {
    void execute(final Book book) throws CreateBookGatewayException;
}
