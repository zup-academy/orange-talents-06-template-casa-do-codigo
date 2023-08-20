package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.service.exception.ExistsByTitleBookServiceException;

public interface ExistsByTitleBookService {
     boolean execute (final String title) throws ExistsByTitleBookServiceException;
}
