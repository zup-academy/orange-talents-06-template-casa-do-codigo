package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;

import java.util.Optional;

public interface GetCategoryByIdService {
    Optional<CategoryDatabase> execute(final Long id);
}
