package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.domain.autor.Autor;
import com.projeto.casadocodigo.gateway.exception.CreateGatewayException;


public interface CreateAutorGateway {
    void execute(final Autor autor) throws CreateGatewayException;
}
