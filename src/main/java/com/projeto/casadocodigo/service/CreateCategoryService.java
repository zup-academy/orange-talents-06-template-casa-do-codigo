package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.domain.category.Category;
import com.projeto.casadocodigo.gateway.exception.CreateCategoryGatewayException;
import com.projeto.casadocodigo.service.exception.CreateCategoryServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;

public interface CreateCategoryService {
    void execute(final Category category) throws ServiceException;
}
