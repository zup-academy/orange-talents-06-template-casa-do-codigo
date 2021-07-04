package br.com.zypacademy.casaDoCodigo.repository;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zypacademy.casaDoCodigo.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Optional<Estado> findByNome(@NotBlank String nomeEstado);

	

}
