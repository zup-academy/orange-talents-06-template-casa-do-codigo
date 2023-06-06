package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.gateway.ExistsByEmailGateway;
import com.projeto.casadocodigo.gateway.database.repository.AutorRepository;
import com.projeto.casadocodigo.gateway.exception.ExistsByEmailGatewayException;
import org.springframework.stereotype.Component;

@Component
public class ExistsByEmailGatewayPostgresql implements ExistsByEmailGateway {
    AutorRepository autorRepository;

    public ExistsByEmailGatewayPostgresql(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean execute(String email) throws ExistsByEmailGatewayException {
        try {
            return autorRepository.existsByEmail(email);
        }catch (Exception e){
            throw new ExistsByEmailGatewayException(e);
        }
    }
}
