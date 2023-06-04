package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.domain.autor.Autor;
import com.projeto.casadocodigo.gateway.CreateAutorGateway;
import com.projeto.casadocodigo.gateway.database.model.AutorDatabase;
import com.projeto.casadocodigo.gateway.database.repository.AutorRepository;
import com.projeto.casadocodigo.gateway.exception.CreateGatewayException;
import org.springframework.stereotype.Component;

@Component
public class CreateAutorGatewayPostgresql implements CreateAutorGateway {

    AutorRepository autorRepository;
    ExistsByEmailGatewayPostgresql findByEmailGatewayPostgresql;


    public CreateAutorGatewayPostgresql(AutorRepository autorRepository, ExistsByEmailGatewayPostgresql findByEmailGatewayPostgresql) {
        this.autorRepository = autorRepository;
        this.findByEmailGatewayPostgresql = findByEmailGatewayPostgresql;
    }

    @Override
    public void execute(Autor autor) throws CreateGatewayException{
        try {

                AutorDatabase entity = AutorDatabase.model(autor);

                    AutorDatabase savedEntity = autorRepository.save(entity);
                    Autor.fromDatabase(savedEntity);



        } catch (Exception e) {
            throw new CreateGatewayException(e);
        }
    }
}
