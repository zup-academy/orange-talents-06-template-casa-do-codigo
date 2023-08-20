package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.gateway.ExistsByIsbnBookGateway;
import com.projeto.casadocodigo.gateway.database.repository.BookRepository;
import com.projeto.casadocodigo.gateway.exception.ExistsByIsbnBookGatewayException;
import org.springframework.stereotype.Component;

@Component
public class ExistsByIsbnBookGatewayPostgresql implements ExistsByIsbnBookGateway {
    BookRepository bookRepository;

    public ExistsByIsbnBookGatewayPostgresql(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean execute(String isbn) throws ExistsByIsbnBookGatewayException {
        try {
            return bookRepository.existsByIsbn(isbn);
        } catch (Exception e) {
            throw new ExistsByIsbnBookGatewayException(e);
        }

    }
}
