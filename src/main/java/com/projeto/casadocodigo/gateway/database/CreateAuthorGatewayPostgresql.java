package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.gateway.CreateAuthorGateway;
import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import com.projeto.casadocodigo.gateway.database.repository.AuthorRepository;
import com.projeto.casadocodigo.gateway.exception.CreateAuthorGatewayException;
import com.projeto.casadocodigo.gateway.exception.GatewayException;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorGatewayPostgresql implements CreateAuthorGateway {

    AuthorRepository authorRepository;

    public CreateAuthorGatewayPostgresql(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    public void execute(Author author) throws GatewayException {
        try {
            authorRepository.save(new AuthorDatabase(author));
        } catch (Exception e) {
            throw new CreateAuthorGatewayException(e);
        }
    }
}
