package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;

import java.util.Optional;

public interface GetCategoryByIdGateway {
    Optional<CategoryDatabase> execute(final Long id);
}
