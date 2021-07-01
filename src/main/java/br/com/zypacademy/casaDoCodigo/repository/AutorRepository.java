package br.com.zypacademy.casaDoCodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zypacademy.casaDoCodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);

}
