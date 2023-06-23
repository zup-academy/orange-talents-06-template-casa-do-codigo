package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.gateway.GetCategoryByIdGateway;
import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;
import com.projeto.casadocodigo.gateway.database.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCategoryByIdGatewayPostgresql implements GetCategoryByIdGateway {
    CategoryRepository categoryRepository;

    public GetCategoryByIdGatewayPostgresql(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<CategoryDatabase> execute(Long id) {
        return categoryRepository.findById(id);
    }
}
