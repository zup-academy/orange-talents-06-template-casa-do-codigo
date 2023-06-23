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

    public CategoryDatabase(){

    }
    public CategoryDatabase(Long category) {
        this.id = category;
    }

    public CategoryDatabase(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDatabase(Category category) {
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
