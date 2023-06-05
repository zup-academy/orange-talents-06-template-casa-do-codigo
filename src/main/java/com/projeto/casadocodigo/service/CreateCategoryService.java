package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.domain.category.Category;
import com.projeto.casadocodigo.service.exception.CreateCategoryServiceException;

public interface CreateCategoryService {
    void execute(final Category category) throws CreateCategoryServiceException;
}
