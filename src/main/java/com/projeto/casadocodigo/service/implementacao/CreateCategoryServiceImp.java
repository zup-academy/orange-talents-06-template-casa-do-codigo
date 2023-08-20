package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.category.Category;
import com.projeto.casadocodigo.gateway.CreateCategoryGateway;
import com.projeto.casadocodigo.gateway.exception.CreateCategoryGatewayException;
import com.projeto.casadocodigo.service.CreateCategoryService;
import com.projeto.casadocodigo.service.ExistsByCategoryNameService;
import com.projeto.casadocodigo.service.exception.CreateCategoryServiceException;
import com.projeto.casadocodigo.service.exception.ExistsByCategoryNameServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryServiceImp implements CreateCategoryService {
    private final CreateCategoryGateway createCategoryGateway;
    private final ExistsByCategoryNameService existsByCategoryNameService;

    public CreateCategoryServiceImp(CreateCategoryGateway createCategoryGateway, ExistsByCategoryNameService existsByCategoryNameService) {
        this.createCategoryGateway = createCategoryGateway;
        this.existsByCategoryNameService = existsByCategoryNameService;
    }

    public void execute(final Category category) throws ServiceException {
        checkIfCategoryNameExists(category.getName());

        try {
            createCategoryGateway.execute(category);
        } catch (CreateCategoryGatewayException e) {
            throw new CreateCategoryServiceException("Problemas ao criar uma categoria");
        }
    }

    private void checkIfCategoryNameExists(final String name) throws ExistsByCategoryNameServiceException {
        if (existsByCategoryNameService.execute(name)) {
            throw new ExistsByCategoryNameServiceException("Já existe uma categoria com o nome " + name+ ", tente outro");
        }
    }
}
