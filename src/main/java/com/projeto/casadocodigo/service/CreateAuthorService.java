package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.domain.Author.Author;
import com.projeto.casadocodigo.gateway.exception.ExistsByEmailGatewayException;
import com.projeto.casadocodigo.service.exception.ExistsEmailServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;

public interface CreateAuthorService {

    public void execute(final Author Author) throws ServiceException;

}
