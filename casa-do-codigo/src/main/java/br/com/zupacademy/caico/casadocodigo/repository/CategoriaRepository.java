package br.com.zupacademy.caico.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.caico.casadocodigo.model.Categorias;

@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Long> {

}
