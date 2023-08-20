package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.gateway.exception.ExistsByCategoryNameGatewayException;

public interface ExistsByCategoryNameGateway {
    boolean execute(final String name) throws ExistsByCategoryNameGatewayException;
}
