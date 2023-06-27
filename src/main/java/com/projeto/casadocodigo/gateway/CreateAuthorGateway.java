package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.gateway.exception.CreateGatewayException;

public interface CreateAuthorGateway {
    void execute(final Author author) throws CreateGatewayException;

}
