package com.projeto.casadocodigo.api.request.category;

import com.projeto.casadocodigo.domain.category.Category;
import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {
    @NotBlank(message = "Nome da categoria é obrigatório")
    private String name;

    public Category toDomain(){
        return new Category(name);
    }
    public String getName() {
        return name;
    }
}
