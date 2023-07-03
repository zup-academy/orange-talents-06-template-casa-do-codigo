package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.api.response.book.GetAllBooksDetailResponse;
import com.projeto.casadocodigo.domain.book.Book;
import com.projeto.casadocodigo.gateway.GetAllBookDetailsByIdGateway;
import com.projeto.casadocodigo.gateway.database.model.BookDatabase;
import com.projeto.casadocodigo.gateway.database.repository.BookRepository;
import com.projeto.casadocodigo.gateway.exception.BookNotFoundGatewayException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetAllBookDetailsByIdGatewayPostgresql implements GetAllBookDetailsByIdGateway {

    BookRepository bookRepository;

    public GetAllBookDetailsByIdGatewayPostgresql(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public GetAllBooksDetailResponse execute(final Long id) throws BookNotFoundGatewayException {
        Optional<BookDatabase> bookDatabase = bookRepository.findById(id);



            if(bookDatabase.isPresent()){
            BookDatabase entityBookDatabase = bookDatabase.get();
            Book entityBook = entityBookDatabase.toBookResponse();
            GetAllBooksDetailResponse getAllBooksDetailResponse = entityBook.getAllBooksDetailResponse();
            return getAllBooksDetailResponse;
            }else{
                throw new BookNotFoundGatewayException("O livro solicitado não existe");
            }

    }
}
