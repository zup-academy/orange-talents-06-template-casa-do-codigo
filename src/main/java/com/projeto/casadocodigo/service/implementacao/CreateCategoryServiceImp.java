package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.category.Category;
import com.projeto.casadocodigo.gateway.CreateCategoryGateway;
import com.projeto.casadocodigo.gateway.exception.CreateCategoryGatewayException;
import com.projeto.casadocodigo.service.CreateCategoryService;
import com.projeto.casadocodigo.service.exception.CreateCategoryServiceException;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryServiceImp implements CreateCategoryService {
    private final CreateCategoryGateway createCategoryGateway;

    public CreateCategoryServiceImp(CreateCategoryGateway createCategoryGateway) {
        this.createCategoryGateway = createCategoryGateway;
    }

    @Override
    public void execute(Category category) throws CreateCategoryServiceException {
        try {
            createCategoryGateway.execute(category);
        }catch(CreateCategoryGatewayException e){
            throw new CreateCategoryServiceException("O nome da categoria deve ser único");
        }
    }
}
