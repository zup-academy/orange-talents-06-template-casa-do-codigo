package com.projeto.casadocodigo.gateway.database.model;

import com.projeto.casadocodigo.domain.category.Category;
import jakarta.persistence.*;

@Entity
public class CategoryDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name", unique = true)
    private String name;

    public CategoryDatabase(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CategoryDatabase model(Category category) {
        return new CategoryDatabase(category.getId(), category.getName());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
