package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.service.exception.ExistsByCategoryNameServiceException;

public interface ExistsByCategoryNameService {
    public boolean execute(final String name) throws ExistsByCategoryNameServiceException;
}
