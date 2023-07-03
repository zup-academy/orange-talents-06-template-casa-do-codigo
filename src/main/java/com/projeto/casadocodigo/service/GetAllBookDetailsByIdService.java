package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.api.response.book.GetAllBooksDetailResponse;
import com.projeto.casadocodigo.gateway.exception.BookNotFoundGatewayException;

public interface GetAllBookDetailsByIdService {
    public GetAllBooksDetailResponse execute(final Long id) throws BookNotFoundGatewayException;
}
