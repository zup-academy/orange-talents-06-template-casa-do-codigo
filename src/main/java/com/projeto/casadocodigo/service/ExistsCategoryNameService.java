package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.service.exception.ExistsCategoryNameServiceException;

public interface ExistsCategoryNameService {
    public boolean execute(final String name) throws ExistsCategoryNameServiceException;
}
