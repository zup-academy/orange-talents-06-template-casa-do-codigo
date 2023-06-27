package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.gateway.ExistsByEmailGateway;
import com.projeto.casadocodigo.service.ExistsByEmailService;
import com.projeto.casadocodigo.service.exception.ExistsEmailServiceException;
import org.springframework.stereotype.Service;

@Service
public class ExistsByEmailServiceImp implements ExistsByEmailService {

    private final ExistsByEmailGateway existsByEmailGateway;

    public ExistsByEmailServiceImp(ExistsByEmailGateway existsByEmailGateway) {
        this.existsByEmailGateway = existsByEmailGateway;
    }

    @Override
    public boolean execute(String email) throws ExistsEmailServiceException {
        try {
            return existsByEmailGateway.execute(email);
        } catch (Exception e) {
            throw new ExistsEmailServiceException("Erro ao verificar e-mail");
        }
    }
}
