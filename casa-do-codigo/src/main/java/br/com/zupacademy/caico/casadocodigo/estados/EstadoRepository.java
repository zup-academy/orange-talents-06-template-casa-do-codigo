package br.com.zupacademy.caico.casadocodigo.estados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estados, Long>{

	Estados findByNomeAndPaisId(String nome, Long id);

}
