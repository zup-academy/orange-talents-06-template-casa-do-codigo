package com.projeto.casadocodigo.api.controller;

import com.projeto.casadocodigo.api.response.book.GetAllBooksDetailResponse;
import com.projeto.casadocodigo.gateway.exception.BookNotFoundGatewayException;
import com.projeto.casadocodigo.service.GetAllBookDetailsByIdService;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllBookDetailsByIdController {
    private final GetAllBookDetailsByIdService getAllBookDetailsByIdService;

    public GetAllBookDetailsByIdController(GetAllBookDetailsByIdService getAllBookDetailsByIdService) {
        this.getAllBookDetailsByIdService = getAllBookDetailsByIdService;
    }

    @GetMapping(value = "/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetAllBooksDetailResponse execute(@PathVariable("id") Long id) throws ServiceException, BookNotFoundGatewayException {
        return getAllBookDetailsByIdService.execute(id);
    }
}
