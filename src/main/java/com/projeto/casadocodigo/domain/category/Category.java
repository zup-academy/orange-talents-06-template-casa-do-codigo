package com.projeto.casadocodigo.domain.category;

import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;

public class Category {
    private Long id;
    private String name;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Category(String name) {
        this.name = name;
    }

    public static Category fromDataBase(CategoryDatabase categoryDatabase) {
        return new Category(categoryDatabase.getId(), categoryDatabase.getName());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
