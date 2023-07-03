package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.api.response.book.BookResponse;
import com.projeto.casadocodigo.domain.book.Book;
import com.projeto.casadocodigo.gateway.GetAllBooksGateway;
import com.projeto.casadocodigo.gateway.database.model.BookDatabase;
import com.projeto.casadocodigo.gateway.database.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllBooksGatewayPostgresql implements GetAllBooksGateway {

    BookRepository bookRepository;

    public GetAllBooksGatewayPostgresql(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponse> execute() {
        List<BookDatabase> listDatabase = bookRepository.findAll();
        List<BookResponse> listResponse = new ArrayList<>();

        listDatabase.forEach(bookDatabase -> {
            Book book = bookDatabase.toBook();
            BookResponse bookResponse = book.toBookResponse();
            listResponse.add(bookResponse);
        });
        return listResponse;
    }
}
