package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.category.Category;
import com.projeto.casadocodigo.gateway.CreateCategoryGateway;
import com.projeto.casadocodigo.gateway.exception.CreateCategoryGatewayException;
import com.projeto.casadocodigo.service.CreateCategoryService;
import com.projeto.casadocodigo.service.ExistsCategoryNameService;
import com.projeto.casadocodigo.service.exception.CreateCategoryServiceException;
import com.projeto.casadocodigo.service.exception.ExistsCategoryNameServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryServiceImp implements CreateCategoryService {
    private final CreateCategoryGateway createCategoryGateway;
    private final ExistsCategoryNameService existsCategoryNameService;

    public CreateCategoryServiceImp(CreateCategoryGateway createCategoryGateway, ExistsCategoryNameService existsCategoryNameService) {
        this.createCategoryGateway = createCategoryGateway;
        this.existsCategoryNameService = existsCategoryNameService;
    }


    public void execute(final Category category) throws ServiceException {

            if (existsCategoryNameService.execute(category.getName())){
                throw new ExistsCategoryNameServiceException("Nome da categoria já existe");
            }
        try {
            createCategoryGateway.execute(category);
        } catch (CreateCategoryGatewayException e) {
            throw new CreateCategoryServiceException("Problemas ao criar uma categoria");
        }
    }
}
