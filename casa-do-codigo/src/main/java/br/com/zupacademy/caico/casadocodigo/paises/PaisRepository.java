package br.com.zupacademy.caico.casadocodigo.paises;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Paises, Long>{

}
