package com.projeto.casadocodigo.service;

import com.projeto.casadocodigo.domain.book.Book;
import com.projeto.casadocodigo.service.exception.ServiceException;

public interface CreateBookService {
    void execute(final Book book, final Long authorId, final Long categoryId) throws ServiceException;
}
