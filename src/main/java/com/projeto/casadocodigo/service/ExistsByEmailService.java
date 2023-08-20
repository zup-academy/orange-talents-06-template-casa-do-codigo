package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.service.exception.ServiceException;

public interface ExistsByEmailService {
    public boolean execute(final String email) throws ServiceException;
}
