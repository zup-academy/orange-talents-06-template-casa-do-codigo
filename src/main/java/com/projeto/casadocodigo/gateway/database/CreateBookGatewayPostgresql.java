package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.domain.book.Book;
import com.projeto.casadocodigo.gateway.CreateBookGateway;
import com.projeto.casadocodigo.gateway.database.model.BookDatabase;
import com.projeto.casadocodigo.gateway.database.repository.BookRepository;
import com.projeto.casadocodigo.gateway.exception.CreateBookGatewayException;
import org.springframework.stereotype.Component;

@Component
public class CreateBookGatewayPostgresql implements CreateBookGateway {
    BookRepository bookRepository;

    public CreateBookGatewayPostgresql(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(Book book) throws CreateBookGatewayException {
        try {
            BookDatabase entity = new BookDatabase(book);
            BookDatabase bookSaved = bookRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CreateBookGatewayException(e);
        }
    }
}
