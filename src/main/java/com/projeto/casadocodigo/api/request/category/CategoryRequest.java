package com.projeto.casadocodigo.api.request.category;

import com.projeto.casadocodigo.domain.category.Category;
import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;
import com.projeto.casadocodigo.service.genericValidator.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {
    @NotBlank(message = "Nome da categoria é obrigatório")
    @UniqueValue(message = "Nome da categoria deve ser único", fieldName = "name", domainClass = CategoryDatabase.class)
    private String name;

    public Category toDomain(){
        return new Category(name);
    }
    public String getName() {
        return name;
    }
}
