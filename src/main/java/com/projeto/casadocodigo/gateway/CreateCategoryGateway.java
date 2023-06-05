package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.domain.category.Category;
import com.projeto.casadocodigo.gateway.exception.CreateCategoryGatewayException;

public interface CreateCategoryGateway {
    void execute(final Category category) throws CreateCategoryGatewayException;
}
