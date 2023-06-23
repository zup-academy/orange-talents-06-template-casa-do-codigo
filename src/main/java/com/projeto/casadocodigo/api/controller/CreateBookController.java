package com.projeto.casadocodigo.api.controller;

import com.projeto.casadocodigo.api.request.book.BookRequest;
import com.projeto.casadocodigo.service.CreateBookService;
import com.projeto.casadocodigo.service.exception.ServiceException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateBookController {
    private final CreateBookService createBookService;

    public CreateBookController(CreateBookService createBookService) {
        this.createBookService = createBookService;
    }

    @PostMapping(value = "/book")
    @ResponseStatus(HttpStatus.OK)
    public void execute(@RequestBody @Valid BookRequest bookRequest) throws ServiceException {
        createBookService.execute(bookRequest.toDomain(), bookRequest.getAuthor(), bookRequest.getCategory());
    }
}
