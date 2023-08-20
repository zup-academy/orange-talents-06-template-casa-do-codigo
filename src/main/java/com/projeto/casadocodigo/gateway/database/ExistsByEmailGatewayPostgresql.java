package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.gateway.ExistsByEmailGateway;
import com.projeto.casadocodigo.gateway.database.repository.AuthorRepository;
import com.projeto.casadocodigo.gateway.exception.ExistsByEmailGatewayException;
import org.springframework.stereotype.Component;

@Component
public class ExistsByEmailGatewayPostgresql implements ExistsByEmailGateway {
    AuthorRepository authorRepository;

    public ExistsByEmailGatewayPostgresql(AuthorRepository AuthorRepository) {
        this.authorRepository = AuthorRepository;
    }

    @Override
    public boolean execute(String email) throws ExistsByEmailGatewayException {
        try {
            return authorRepository.existsByEmail(email);
        } catch (Exception e) {
            throw new ExistsByEmailGatewayException(e);
        }
    }
}
