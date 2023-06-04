package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.domain.autor.Autor;
import com.projeto.casadocodigo.gateway.exception.ExistsByEmailGatewayException;
import com.projeto.casadocodigo.service.exception.ExistsEmailServiceException;

public interface CreateAutorService {

    public void execute(final Autor autor) throws ExistsEmailServiceException;

}
