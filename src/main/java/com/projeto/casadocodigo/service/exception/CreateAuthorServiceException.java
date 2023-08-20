package com.projeto.casadocodigo.service.exception;

import com.projeto.casadocodigo.gateway.exception.CreateGatewayException;

public class CreateAuthorServiceException extends ServiceException {
    public CreateAuthorServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateAuthorServiceException(String message) {
        super(message);
    }
}
