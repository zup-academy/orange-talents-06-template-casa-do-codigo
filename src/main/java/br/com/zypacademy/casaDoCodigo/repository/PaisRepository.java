package br.com.zypacademy.casaDoCodigo.repository;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zypacademy.casaDoCodigo.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{

	Optional<Pais> findByNome(@NotEmpty @NotNull String pais);

}
