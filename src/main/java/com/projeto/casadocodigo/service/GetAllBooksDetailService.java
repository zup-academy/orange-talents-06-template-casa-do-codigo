package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.api.response.book.GetAllBooksDetailResponse;
import com.projeto.casadocodigo.gateway.exception.BookNotFoundGatewayException;
import com.projeto.casadocodigo.service.exception.ServiceException;

public interface GetAllBooksDetailService {
    public GetAllBooksDetailResponse execute(final Long id) throws BookNotFoundGatewayException;
}
