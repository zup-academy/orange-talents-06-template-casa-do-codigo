package com.projeto.casadocodigo.gateway.database.repository;

import com.projeto.casadocodigo.gateway.database.model.AutorDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AutorRepository extends JpaRepository<AutorDatabase, Long> {

}
