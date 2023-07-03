package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.api.response.book.GetAllBooksDetailResponse;
import com.projeto.casadocodigo.gateway.GetAllBookDetailsByIdGateway;
import com.projeto.casadocodigo.gateway.exception.BookNotFoundGatewayException;
import com.projeto.casadocodigo.service.GetAllBookDetailsByIdService;
import org.springframework.stereotype.Service;

@Service
public class GetAllBookDetailsByIdServiceImp implements GetAllBookDetailsByIdService {
    private final GetAllBookDetailsByIdGateway getAllBookDetailsByIdGateway;

    public GetAllBookDetailsByIdServiceImp(GetAllBookDetailsByIdGateway getAllBookDetailsByIdGateway) {
        this.getAllBookDetailsByIdGateway = getAllBookDetailsByIdGateway;
    }

    @Override
    public GetAllBooksDetailResponse execute(final Long id) throws BookNotFoundGatewayException {

        try {
            return getAllBookDetailsByIdGateway.execute(id);
        } catch (BookNotFoundGatewayException e) {
            throw new BookNotFoundGatewayException(e.getMessage());
        }

    }
}
