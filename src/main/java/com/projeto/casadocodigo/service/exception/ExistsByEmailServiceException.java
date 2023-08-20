package com.projeto.casadocodigo.service.exception;

public class ExistsByEmailServiceException extends ServiceException {

    public ExistsByEmailServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistsByEmailServiceException(String message) {
        super(message);
    }
}
