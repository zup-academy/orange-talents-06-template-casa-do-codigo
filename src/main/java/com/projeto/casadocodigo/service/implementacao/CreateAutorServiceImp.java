package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.autor.Autor;
import com.projeto.casadocodigo.gateway.CreateAutorGateway;
import com.projeto.casadocodigo.gateway.exception.CreateGatewayException;
import com.projeto.casadocodigo.service.CreateAutorService;
import com.projeto.casadocodigo.service.ExistsByEmailService;
import com.projeto.casadocodigo.service.exception.CreateAutorServiceException;
import com.projeto.casadocodigo.service.exception.ExistsEmailServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class CreateAutorServiceImp implements CreateAutorService {
    private final CreateAutorGateway createAutorGateway;
    private final ExistsByEmailService existsByEmailService;

    // Injeção interface por meio de construtor
    public CreateAutorServiceImp(CreateAutorGateway createAutorGateway, ExistsByEmailService existsByEmailService) {
        this.createAutorGateway = createAutorGateway;
        this.existsByEmailService = existsByEmailService;
    }

    public void execute(final Autor autor) throws ServiceException {
        try {
            if (existsByEmailService.execute(autor.getEmail())) {
                throw new ExistsEmailServiceException("E-mail já existe na base de dados");
            }

            createAutorGateway.execute(autor);
        } catch (CreateGatewayException e) {
            throw new CreateAutorServiceException("Problemas ao criar autor", e);
        }
    }

}