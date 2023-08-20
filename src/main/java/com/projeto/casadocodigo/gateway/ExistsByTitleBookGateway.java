package com.projeto.casadocodigo.gateway;

import com.projeto.casadocodigo.gateway.exception.ExistsByTitleBookGatewayException;

public interface ExistsByTitleBookGateway {
     boolean execute(final String title) throws ExistsByTitleBookGatewayException;
}
