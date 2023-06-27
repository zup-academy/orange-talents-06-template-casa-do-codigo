package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.service.exception.ServiceException;

public interface CreateAuthorService {

    public void execute(final Author Author) throws ServiceException;

}
