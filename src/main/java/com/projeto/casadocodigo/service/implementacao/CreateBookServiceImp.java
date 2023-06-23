package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.domain.book.Book;
import com.projeto.casadocodigo.domain.category.Category;
import com.projeto.casadocodigo.gateway.CreateBookGateway;
import com.projeto.casadocodigo.gateway.GetCategoryByIdGateway;
import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import com.projeto.casadocodigo.gateway.database.model.BookDatabase;
import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;
import com.projeto.casadocodigo.gateway.database.repository.AuthorRepository;
import com.projeto.casadocodigo.gateway.exception.CreateBookGatewayException;
import com.projeto.casadocodigo.gateway.exception.CreateGatewayException;
import com.projeto.casadocodigo.service.CreateBookService;
import com.projeto.casadocodigo.service.GetAuthorByIdService;
import com.projeto.casadocodigo.service.exception.CreateBookServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateBookServiceImp implements CreateBookService {
    private final CreateBookGateway createBookGateway;
    private final GetAuthorByIdService getAuthorByIdService;
    private final GetCategoryByIdGateway getCategoryByIdGateway;


    public CreateBookServiceImp(CreateBookGateway createBookGateway, GetAuthorByIdService getAuthorByIdService, GetCategoryByIdGateway getCategoryByIdGateway) {
        this.createBookGateway = createBookGateway;
        this.getAuthorByIdService = getAuthorByIdService;
        this.getCategoryByIdGateway = getCategoryByIdGateway;
    }

    public void execute(final Book book, final Long authorId, final Long categoryId) throws ServiceException {
        try {
            final Optional<AuthorDatabase> author = getAuthorByIdService.execute(authorId);
            final Optional<CategoryDatabase> category = getCategoryByIdGateway.execute(categoryId);

            book.setAuthor(author.orElse(null).getId());
            book.setCategory(category.orElse(null).getId());

            createBookGateway.execute(book);
        }catch(CreateBookGatewayException e){
            e.printStackTrace();
            throw new CreateBookServiceException("Problemas ao criar um novo livro", e.getCause());
        }
    }
}
// TODO: 20/06/2023 Criar serviço (interface e implementação) para obter um autor através do ID
// TODO: 20/06/2023 Criar serviço (interface e implementação) para obter uma categoria através do ID