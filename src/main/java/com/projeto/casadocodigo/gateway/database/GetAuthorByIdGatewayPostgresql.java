package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.gateway.GetAuthorByIdGateway;
import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import com.projeto.casadocodigo.gateway.database.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetAuthorByIdGatewayPostgresql implements GetAuthorByIdGateway {
    AuthorRepository authorRepository;

    public GetAuthorByIdGatewayPostgresql(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<AuthorDatabase> execute(Long id) {
        return authorRepository.findById(id);
    }
}
