package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.gateway.ExistsByCategoryNameGateway;
import com.projeto.casadocodigo.gateway.database.repository.CategoryRepository;
import com.projeto.casadocodigo.gateway.exception.ExistsByCategoryNameGatewayException;
import org.springframework.stereotype.Component;

@Component
public class ExistsByCategoryNameGatewayPostgresql implements ExistsByCategoryNameGateway {

     CategoryRepository categoryRepository;

    public ExistsByCategoryNameGatewayPostgresql(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean execute(final String name) throws ExistsByCategoryNameGatewayException {

        try {
            return categoryRepository.existsByName(name);
        } catch (Exception e) {
            throw new ExistsByCategoryNameGatewayException(e);
        }
    }
}
