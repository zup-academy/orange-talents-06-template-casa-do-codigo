package br.com.zypacademy.casaDoCodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zypacademy.casaDoCodigo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	Optional<Livro> findByTitulo(Object value);

}
