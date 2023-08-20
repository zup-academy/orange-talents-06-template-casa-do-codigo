package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.gateway.exception.ExistsByIsbnBookGatewayException;

public interface ExistsByIsbnBookGateway {
    boolean execute(final String isbn) throws ExistsByIsbnBookGatewayException;
}
