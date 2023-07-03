package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.api.response.book.GetAllBooksDetailResponse;
import com.projeto.casadocodigo.gateway.GetAllBooksDetailGateway;
import com.projeto.casadocodigo.gateway.exception.BookNotFoundGatewayException;
import com.projeto.casadocodigo.service.GetAllBooksDetailService;
import com.projeto.casadocodigo.service.exception.BookNotFoundServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class GetAllBooksDetailServiceImp implements GetAllBooksDetailService {
    private final GetAllBooksDetailGateway getAllBooksDetailGateway;

    public GetAllBooksDetailServiceImp(GetAllBooksDetailGateway getAllBooksDetailGateway) {
        this.getAllBooksDetailGateway = getAllBooksDetailGateway;
    }

    @Override
    public GetAllBooksDetailResponse execute(final Long id) throws BookNotFoundGatewayException {

        try {
            return getAllBooksDetailGateway.execute(id);
        } catch (BookNotFoundGatewayException e) {
            throw new BookNotFoundGatewayException(e.getMessage());
        }

    }
}
