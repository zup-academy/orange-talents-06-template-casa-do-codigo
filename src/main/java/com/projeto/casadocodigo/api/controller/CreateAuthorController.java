package com.projeto.casadocodigo.api.controller;

import com.projeto.casadocodigo.api.request.Author.AuthorRequest;
import com.projeto.casadocodigo.service.CreateAuthorService;
import com.projeto.casadocodigo.service.exception.ServiceException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class CreateAuthorController {
    private final CreateAuthorService createAuthorService;

    public CreateAuthorController(CreateAuthorService createAuthorService) {
        this.createAuthorService = createAuthorService;
    }

    @PostMapping(value = "/author")
    @ResponseStatus(code = HttpStatus.OK)
    @Transactional
    public void execute(@RequestBody @Valid AuthorRequest AuthorRequest) throws ServiceException {
        // Chama o serviço que cria um Author
        createAuthorService.execute(AuthorRequest.toDomain());

    }
}
