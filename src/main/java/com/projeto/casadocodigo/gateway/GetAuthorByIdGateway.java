package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;

import java.util.Optional;

public interface GetAuthorByIdGateway {
    Optional<AuthorDatabase> execute(final Long id);
}
