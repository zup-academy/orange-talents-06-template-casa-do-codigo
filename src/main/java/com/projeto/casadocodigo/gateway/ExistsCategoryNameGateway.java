package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.gateway.exception.ExistsCategoryNameGatewayException;

public interface ExistsCategoryNameGateway {
    boolean execute(final String name) throws ExistsCategoryNameGatewayException;
}
