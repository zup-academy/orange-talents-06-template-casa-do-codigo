package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.api.response.book.BookResponse;
import com.projeto.casadocodigo.gateway.ListAllBooksGateway;
import com.projeto.casadocodigo.gateway.database.model.BookDatabase;
import com.projeto.casadocodigo.service.ListAllBooksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllBooksServiceImp implements ListAllBooksService {

    private final ListAllBooksGateway listAllBooksGateway;

    public ListAllBooksServiceImp(ListAllBooksGateway listAllBooksGateway) {
        this.listAllBooksGateway = listAllBooksGateway;
    }

    @Override
    public List<BookResponse> execute() {

        return listAllBooksGateway.execute();
    }
}
