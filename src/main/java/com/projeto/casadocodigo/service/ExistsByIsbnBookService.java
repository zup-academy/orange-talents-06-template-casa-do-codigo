package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.service.exception.ExistsByIsbnBookServiceException;

public interface ExistsByIsbnBookService {
    boolean execute(final String isbn) throws ExistsByIsbnBookServiceException;
}
