package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.domain.Author.Author;
import com.projeto.casadocodigo.gateway.CreateAuthorGateway;
import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import com.projeto.casadocodigo.gateway.database.repository.AuthorRepository;
import com.projeto.casadocodigo.gateway.exception.CreateGatewayException;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorGatewayPostgresql implements CreateAuthorGateway {

    AuthorRepository AuthorRepository;
    ExistsByEmailGatewayPostgresql findByEmailGatewayPostgresql;


    public CreateAuthorGatewayPostgresql(AuthorRepository AuthorRepository, ExistsByEmailGatewayPostgresql findByEmailGatewayPostgresql) {
        this.AuthorRepository = AuthorRepository;
        this.findByEmailGatewayPostgresql = findByEmailGatewayPostgresql;
    }

    @Override
    public void execute(Author Author) throws CreateGatewayException{
        try {

                AuthorDatabase entity = AuthorDatabase.model(Author);

                    AuthorDatabase savedEntity = AuthorRepository.save(entity);
                    Author.fromDatabase(savedEntity);



        } catch (Exception e) {
            throw new CreateGatewayException(e);
        }
    }
}
