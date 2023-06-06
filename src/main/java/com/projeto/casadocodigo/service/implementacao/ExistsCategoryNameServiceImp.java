package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.gateway.ExistsCategoryNameGateway;
import com.projeto.casadocodigo.gateway.exception.ExistsCategoryNameGatewayException;
import com.projeto.casadocodigo.service.ExistsCategoryNameService;
import com.projeto.casadocodigo.service.exception.ExistsCategoryNameServiceException;
import org.springframework.stereotype.Service;

@Service
public class ExistsCategoryNameServiceImp implements ExistsCategoryNameService {
    private final ExistsCategoryNameGateway existsCategoryNameGateway;

    public ExistsCategoryNameServiceImp(ExistsCategoryNameGateway existsCategoryNameGateway) {
        this.existsCategoryNameGateway = existsCategoryNameGateway;
    }

    @Override
    public boolean execute(String name) throws ExistsCategoryNameServiceException {
        try {
            return existsCategoryNameGateway.execute(name);
        } catch (ExistsCategoryNameGatewayException e) {
            throw new ExistsCategoryNameServiceException("Erro inesperado ao verificar nome da categoria");
        }
    }
}
