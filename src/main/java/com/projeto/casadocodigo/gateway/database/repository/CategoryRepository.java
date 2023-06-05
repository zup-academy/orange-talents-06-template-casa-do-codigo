package com.projeto.casadocodigo.gateway.database.repository;


import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDatabase, Long> {

}
