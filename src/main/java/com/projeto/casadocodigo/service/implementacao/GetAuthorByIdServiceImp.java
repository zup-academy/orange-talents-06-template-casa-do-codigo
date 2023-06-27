package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.gateway.GetAuthorByIdGateway;
import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import com.projeto.casadocodigo.service.GetAuthorByIdService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAuthorByIdServiceImp implements GetAuthorByIdService {

    private final GetAuthorByIdGateway getAuthorByIdGateway;

    public GetAuthorByIdServiceImp(GetAuthorByIdGateway getAuthorByIdGateway) {
        this.getAuthorByIdGateway = getAuthorByIdGateway;
    }

    @Override
    public Optional<AuthorDatabase> execute(final Long id) {
        return getAuthorByIdGateway.execute(id);
    }
}
