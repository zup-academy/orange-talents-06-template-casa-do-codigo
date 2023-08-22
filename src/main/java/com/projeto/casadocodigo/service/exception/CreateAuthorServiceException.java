package com.projeto.casadocodigo.service.exception;

public class CreateAuthorServiceException extends ServiceException {
    public CreateAuthorServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateAuthorServiceException(String message) {
        super(message);
    }
}
