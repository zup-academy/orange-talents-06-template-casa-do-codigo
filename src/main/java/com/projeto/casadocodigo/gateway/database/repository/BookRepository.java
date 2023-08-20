package com.projeto.casadocodigo.gateway.database.repository;

import com.projeto.casadocodigo.gateway.database.model.BookDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookDatabase, Long> {
    boolean existsByTitle(String title);
    boolean existsByIsbn(String isbn);
}
