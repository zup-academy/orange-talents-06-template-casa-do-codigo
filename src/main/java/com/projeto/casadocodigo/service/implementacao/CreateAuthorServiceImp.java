package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.gateway.CreateAuthorGateway;
import com.projeto.casadocodigo.gateway.exception.CreateAuthorGatewayException;
import com.projeto.casadocodigo.gateway.exception.GatewayException;
import com.projeto.casadocodigo.service.CreateAuthorService;
import com.projeto.casadocodigo.service.ExistsByEmailService;
import com.projeto.casadocodigo.service.exception.CreateAuthorServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class CreateAuthorServiceImp implements CreateAuthorService {
    private final CreateAuthorGateway createAuthorGateway;
    private final ExistsByEmailService existsByEmailService;

    public CreateAuthorServiceImp(CreateAuthorGateway createAuthorGateway, ExistsByEmailService existsByEmailService) {
        this.createAuthorGateway = createAuthorGateway;
        this.existsByEmailService = existsByEmailService;
    }

    public void execute(final Author author) throws ServiceException {
        try {
            checkIfEmailExists(author.getEmail());
            createAuthorGateway.execute(author);
        } catch (GatewayException e) {
            throw new CreateAuthorServiceException("Problemas ao criar Author", e);
        }
    }

    private void checkIfEmailExists(String email) throws ServiceException{
            if (existsByEmailService.execute(email)) {
                throw new CreateAuthorServiceException("O e-mail " + email + " já foi cadastrado por outro autor");
            }
    }

}
