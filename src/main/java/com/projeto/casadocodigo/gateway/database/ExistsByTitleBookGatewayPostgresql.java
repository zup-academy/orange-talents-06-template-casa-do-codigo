package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.gateway.ExistsByTitleBookGateway;
import com.projeto.casadocodigo.gateway.database.repository.BookRepository;
import com.projeto.casadocodigo.gateway.exception.ExistsByTitleBookGatewayException;
import org.springframework.stereotype.Component;

@Component
public class ExistsByTitleBookGatewayPostgresql implements ExistsByTitleBookGateway {
    BookRepository bookRepository;

    public ExistsByTitleBookGatewayPostgresql(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean execute(String title) throws ExistsByTitleBookGatewayException {
        try {
            return bookRepository.existsByTitle(title);
        } catch (Exception e) {
            throw new ExistsByTitleBookGatewayException(e);
        }
    }
}
