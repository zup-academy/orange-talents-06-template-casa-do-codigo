package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.gateway.exception.ExistsByEmailGatewayException;

public interface ExistsByEmailGateway {
    boolean execute(final String email) throws ExistsByEmailGatewayException;
}
