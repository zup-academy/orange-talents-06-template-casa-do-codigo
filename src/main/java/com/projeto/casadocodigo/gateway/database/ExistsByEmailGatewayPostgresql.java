package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.gateway.ExistsByEmailGateway;
import com.projeto.casadocodigo.gateway.database.repository.AuthorRepository;
import com.projeto.casadocodigo.gateway.exception.ExistsByEmailGatewayException;
import org.springframework.stereotype.Component;

@Component
public class ExistsByEmailGatewayPostgresql implements ExistsByEmailGateway {
    AuthorRepository AuthorRepository;

    public ExistsByEmailGatewayPostgresql(AuthorRepository AuthorRepository) {
        this.AuthorRepository = AuthorRepository;
    }

    @Override
    public boolean execute(String email) throws ExistsByEmailGatewayException {
        try {
            return AuthorRepository.existsByEmail(email);
        }catch (Exception e){
            throw new ExistsByEmailGatewayException(e);
        }
    }
}
