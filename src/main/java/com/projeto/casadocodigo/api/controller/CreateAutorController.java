package com.projeto.casadocodigo.api.controller;

import com.projeto.casadocodigo.api.request.autor.AutorRequest;
import com.projeto.casadocodigo.gateway.exception.ExistsByEmailGatewayException;
import com.projeto.casadocodigo.service.CreateAutorService;

import com.projeto.casadocodigo.service.exception.ExistsEmailServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RestController
public class CreateAutorController {
    private final CreateAutorService createAutorService;

    public CreateAutorController(CreateAutorService createAutorService) {
        this.createAutorService = createAutorService;
    }

    @PostMapping(value = "/autor")
    @ResponseStatus(code = HttpStatus.OK)
    @Transactional
    public void execute(@RequestBody @Valid AutorRequest autorRequest) throws ServiceException {
        // Chama o serviço que cria um autor
        createAutorService.execute(autorRequest.toDomain());

    }
}
