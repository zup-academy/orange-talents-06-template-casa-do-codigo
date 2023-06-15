package com.projeto.casadocodigo.gateway.database.repository;

import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDatabase, Long> {
     boolean existsByNome(String nome);
     boolean existsByEmail(String email);
}
