package com.projeto.casadocodigo.gateway.database;


import com.projeto.casadocodigo.domain.category.Category;
import com.projeto.casadocodigo.gateway.CreateCategoryGateway;
import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;
import com.projeto.casadocodigo.gateway.database.repository.CategoryRepository;
import com.projeto.casadocodigo.gateway.exception.CreateCategoryGatewayException;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryGatewayPostgresql implements CreateCategoryGateway {
    CategoryRepository categoryRepository;

    public CreateCategoryGatewayPostgresql(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void execute(Category category) throws CreateCategoryGatewayException {
        try {
            CategoryDatabase categoryDatabase = CategoryDatabase.model(category);
            CategoryDatabase categorySaved = categoryRepository.save(categoryDatabase);
            Category.fromDataBase(categorySaved);
        }catch(Exception e){
            throw new CreateCategoryGatewayException(e);
        }
    }
}
