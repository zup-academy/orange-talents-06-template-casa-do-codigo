package com.projeto.casadocodigo.gateway.database.repository;

import com.projeto.casadocodigo.gateway.database.model.AutorDatabase;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<AutorDatabase, Long> {
     boolean existsByNome(String nome);
     boolean existsByEmail(String email);
}
