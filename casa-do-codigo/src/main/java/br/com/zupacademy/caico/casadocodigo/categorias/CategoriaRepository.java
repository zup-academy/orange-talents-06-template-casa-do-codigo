package br.com.zupacademy.caico.casadocodigo.categorias;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Long>{

	Optional<Categorias> findByNome(String nome);

}
