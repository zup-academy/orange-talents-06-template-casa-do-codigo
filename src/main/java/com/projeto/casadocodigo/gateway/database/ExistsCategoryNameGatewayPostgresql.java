package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.gateway.ExistsCategoryNameGateway;
import com.projeto.casadocodigo.gateway.database.repository.CategoryRepository;
import com.projeto.casadocodigo.gateway.exception.ExistsCategoryNameGatewayException;
import org.springframework.stereotype.Component;

@Component
public class ExistsCategoryNameGatewayPostgresql implements ExistsCategoryNameGateway {

     CategoryRepository categoryRepository;

    public ExistsCategoryNameGatewayPostgresql(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean execute(final String name) throws ExistsCategoryNameGatewayException{

        try {
            return categoryRepository.existsByName(name);
        } catch (Exception e) {
            throw new ExistsCategoryNameGatewayException(e);
        }
    }
}
