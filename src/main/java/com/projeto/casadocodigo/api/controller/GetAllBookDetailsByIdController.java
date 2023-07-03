package com.projeto.casadocodigo.api.controller;

import com.projeto.casadocodigo.api.response.book.GetAllBooksDetailResponse;
import com.projeto.casadocodigo.gateway.exception.BookNotFoundGatewayException;
import com.projeto.casadocodigo.service.GetAllBooksDetailService;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllBookDetailsByIdController {
    private final GetAllBooksDetailService getAllBooksDetailService;

    public GetAllBookDetailsByIdController(GetAllBooksDetailService getAllBooksDetailService) {
        this.getAllBooksDetailService = getAllBooksDetailService;
    }

    @GetMapping(value = "/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetAllBooksDetailResponse execute(@PathVariable("id") Long id) throws ServiceException, BookNotFoundGatewayException {
        return getAllBooksDetailService.execute(id);
    }
}
