package com.projeto.casadocodigo.api.controller;


import com.projeto.casadocodigo.api.response.book.BookResponse;
import com.projeto.casadocodigo.service.GetAllBooksService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllBooksController {

    private final GetAllBooksService getAllBooksService;

    public GetAllBooksController(GetAllBooksService getAllBooksService) {
        this.getAllBooksService = getAllBooksService;
    }

    @GetMapping(value = "/listbooks")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> execute(){

        return getAllBooksService.execute();
    }
}
