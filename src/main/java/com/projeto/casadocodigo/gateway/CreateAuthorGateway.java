package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.gateway.exception.CreateAuthorGatewayException;
import com.projeto.casadocodigo.gateway.exception.GatewayException;

public interface CreateAuthorGateway {
    void execute(final Author author) throws GatewayException;

}
