package br.com.zupacademy.caico.casadocodigo.autores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresRepository extends JpaRepository<Autores, Long>{

	Optional<Autores> findByEmail(String email);

}
