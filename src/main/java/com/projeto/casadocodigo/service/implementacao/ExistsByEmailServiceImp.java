package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.gateway.ExistsByEmailGateway;
import com.projeto.casadocodigo.gateway.exception.ExistsByEmailGatewayException;
import com.projeto.casadocodigo.service.ExistsByEmailService;
import com.projeto.casadocodigo.service.exception.ExistsByEmailServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class ExistsByEmailServiceImp implements ExistsByEmailService {

    private final ExistsByEmailGateway existsByEmailGateway;

    public ExistsByEmailServiceImp(ExistsByEmailGateway existsByEmailGateway) {
        this.existsByEmailGateway = existsByEmailGateway;
    }

    @Override
    public boolean execute(final String email) throws ServiceException {
        try {
            return existsByEmailGateway.execute(email);
        } catch (ExistsByEmailGatewayException e) {
            throw new ExistsByEmailServiceException("Problemas ao verificar e-mail", e);
        }
    }
}
