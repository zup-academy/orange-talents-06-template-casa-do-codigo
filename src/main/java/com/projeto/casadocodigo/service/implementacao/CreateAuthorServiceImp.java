package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.gateway.CreateAuthorGateway;
import com.projeto.casadocodigo.gateway.exception.CreateGatewayException;
import com.projeto.casadocodigo.service.CreateAuthorService;
import com.projeto.casadocodigo.service.ExistsByEmailService;
import com.projeto.casadocodigo.service.exception.CreateAuthorServiceException;
import com.projeto.casadocodigo.service.exception.ExistsEmailServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class CreateAuthorServiceImp implements CreateAuthorService {
    private final CreateAuthorGateway createAuthorGateway;
    private final ExistsByEmailService existsByEmailService;

    // Injeção interface por meio de construtor
    public CreateAuthorServiceImp(CreateAuthorGateway createAuthorGateway, ExistsByEmailService existsByEmailService) {
        this.createAuthorGateway = createAuthorGateway;
        this.existsByEmailService = existsByEmailService;
    }

    public void execute(final Author author) throws ServiceException {
        try {
//            if (existsByEmailService.execute(Author.getEmail())) {
//                throw new ExistsEmailServiceException("E-mail já existe na base de dados");
//            }

            createAuthorGateway.execute(author);
        } catch (CreateGatewayException e) {
            throw new CreateAuthorServiceException("Problemas ao criar Author", e);
        }
    }

}