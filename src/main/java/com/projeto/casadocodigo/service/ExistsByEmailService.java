package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.service.exception.ExistsEmailServiceException;

public interface ExistsByEmailService {
    public boolean execute(final String email) throws ExistsEmailServiceException;
}
