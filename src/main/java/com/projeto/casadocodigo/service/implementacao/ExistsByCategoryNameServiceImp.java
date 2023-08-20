package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.gateway.ExistsByCategoryNameGateway;
import com.projeto.casadocodigo.gateway.exception.ExistsByCategoryNameGatewayException;
import com.projeto.casadocodigo.service.ExistsByCategoryNameService;
import com.projeto.casadocodigo.service.exception.ExistsByCategoryNameServiceException;
import org.springframework.stereotype.Service;

@Service
public class ExistsByCategoryNameServiceImp implements ExistsByCategoryNameService {
    private final ExistsByCategoryNameGateway existsByCategoryNameGateway;

    public ExistsByCategoryNameServiceImp(ExistsByCategoryNameGateway existsByCategoryNameGateway) {
        this.existsByCategoryNameGateway = existsByCategoryNameGateway;
    }

    @Override
    public boolean execute(final String name) throws ExistsByCategoryNameServiceException {
        try {
            return existsByCategoryNameGateway.execute(name);
        } catch (ExistsByCategoryNameGatewayException e) {
            throw new ExistsByCategoryNameServiceException("Erro ao verificar nome da categoria");
        }
    }
}
