package com.projeto.casadocodigo.api.controller;

import com.projeto.casadocodigo.api.request.autor.AutorRequest;
import com.projeto.casadocodigo.domain.autor.Autor;
import com.projeto.casadocodigo.service.implementacao.CreateAutorServiceImp;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class CreateAutorController {
    private final CreateAutorServiceImp createAutorServiceImp;
// Renomear createAutorService para createAutorServiceImp(implementação)
    public CreateAutorController(CreateAutorServiceImp createAutorServiceImp) {
        this.createAutorServiceImp = createAutorServiceImp;
    }

    @PostMapping(value = "/autor")
    @ResponseStatus(code = HttpStatus.OK)
    @Transactional
    public void execute(@RequestBody @Valid AutorRequest autorRequest) {
            createAutorServiceImp.execute(autorRequest.toDomain());
    }
}
