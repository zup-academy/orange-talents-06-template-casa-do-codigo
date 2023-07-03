package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.api.response.book.BookResponse;
import com.projeto.casadocodigo.gateway.GetAllBooksGateway;
import com.projeto.casadocodigo.service.GetAllBooksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllBooksServiceImp implements GetAllBooksService {

    private final GetAllBooksGateway getAllBooksGateway;

    public GetAllBooksServiceImp(GetAllBooksGateway getAllBooksGateway) {
        this.getAllBooksGateway = getAllBooksGateway;
    }

    @Override
    public List<BookResponse> execute() {

        return getAllBooksGateway.execute();
    }
}
