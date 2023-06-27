package com.projeto.casadocodigo.api.controller;


import com.projeto.casadocodigo.api.response.book.BookResponse;
import com.projeto.casadocodigo.service.ListAllBooksService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListAllBooksController {

    private final ListAllBooksService listAllBooksService;

    public ListAllBooksController(ListAllBooksService listAllBooksService) {
        this.listAllBooksService = listAllBooksService;
    }

    @GetMapping(value = "/listbooks")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> execute(){

        return listAllBooksService.execute();
    }
}
