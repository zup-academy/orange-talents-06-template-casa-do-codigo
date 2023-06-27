package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.gateway.GetCategoryByIdGateway;
import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;
import com.projeto.casadocodigo.service.GetCategoryByIdService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCategoryByIdServiceImp implements GetCategoryByIdService {
        private final GetCategoryByIdGateway getCategoryByIdGateway;

    public GetCategoryByIdServiceImp(GetCategoryByIdGateway getCategoryByIdGateway) {
        this.getCategoryByIdGateway = getCategoryByIdGateway;
    }

    @Override
    public Optional<CategoryDatabase> execute(Long id) {
        return getCategoryByIdGateway.execute(id);
    }
}
