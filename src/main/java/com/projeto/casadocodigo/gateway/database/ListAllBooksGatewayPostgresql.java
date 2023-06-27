package com.projeto.casadocodigo.gateway.database;

import com.projeto.casadocodigo.api.response.book.BookResponse;
import com.projeto.casadocodigo.domain.book.Book;
import com.projeto.casadocodigo.gateway.ListAllBooksGateway;
import com.projeto.casadocodigo.gateway.database.model.BookDatabase;
import com.projeto.casadocodigo.gateway.database.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListAllBooksGatewayPostgresql implements ListAllBooksGateway {

    BookRepository bookRepository;

    public ListAllBooksGatewayPostgresql(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponse> execute() {
        List<BookDatabase> listDatabase = bookRepository.findAll();
        List<BookResponse> listResponse = new ArrayList<>();

        for (BookDatabase book : listDatabase){
            BookResponse bookResponse = book.toBook();
            listResponse.add(bookResponse);
        }
        return listResponse;
    }
}
