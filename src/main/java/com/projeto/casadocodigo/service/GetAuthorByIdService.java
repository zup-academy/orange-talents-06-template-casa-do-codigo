package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;

import java.util.Optional;

public interface GetAuthorByIdService {
    Optional<AuthorDatabase> execute(final Long id);
}
