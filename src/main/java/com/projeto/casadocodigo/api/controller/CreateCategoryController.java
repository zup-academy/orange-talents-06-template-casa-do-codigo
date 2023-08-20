package com.projeto.casadocodigo.api.controller;

import com.projeto.casadocodigo.api.request.category.CategoryRequest;
import com.projeto.casadocodigo.service.CreateCategoryService;
import com.projeto.casadocodigo.service.exception.ServiceException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateCategoryController {

    private final CreateCategoryService createCategoryService;
    public CreateCategoryController(CreateCategoryService createCategoryService) {
        this.createCategoryService = createCategoryService;
    }

    @PostMapping(value = "/category")
    @ResponseStatus(code = HttpStatus.OK)
    public void execute(@RequestBody @Valid CategoryRequest categoryRequest) throws ServiceException {
        createCategoryService.execute(categoryRequest.toDomain());
    }
}
