package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.book.Book;
import com.projeto.casadocodigo.gateway.CreateBookGateway;
import com.projeto.casadocodigo.gateway.GetCategoryByIdGateway;
import com.projeto.casadocodigo.gateway.database.model.AuthorDatabase;
import com.projeto.casadocodigo.gateway.database.model.CategoryDatabase;
import com.projeto.casadocodigo.gateway.exception.CreateBookGatewayException;
import com.projeto.casadocodigo.service.CreateBookService;
import com.projeto.casadocodigo.service.ExistsByIsbnBookService;
import com.projeto.casadocodigo.service.ExistsByTitleBookService;
import com.projeto.casadocodigo.service.GetAuthorByIdService;
import com.projeto.casadocodigo.service.exception.CreateBookServiceException;
import com.projeto.casadocodigo.service.exception.ExistsByIsbnBookServiceException;
import com.projeto.casadocodigo.service.exception.ExistsByTitleBookServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateBookServiceImp implements CreateBookService {
    private final CreateBookGateway createBookGateway;
    private final GetAuthorByIdService getAuthorByIdService;
    private final GetCategoryByIdGateway getCategoryByIdGateway;
    private final ExistsByTitleBookService existsByTitleBookService;
    private final ExistsByIsbnBookService existsByIsbnBookService;

    public CreateBookServiceImp(CreateBookGateway createBookGateway, GetAuthorByIdService getAuthorByIdService, GetCategoryByIdGateway getCategoryByIdGateway, ExistsByTitleBookService existsByTitleBookService, ExistsByIsbnBookService existsByIsbnBookService) {
        this.createBookGateway = createBookGateway;
        this.getAuthorByIdService = getAuthorByIdService;
        this.getCategoryByIdGateway = getCategoryByIdGateway;
        this.existsByTitleBookService = existsByTitleBookService;
        this.existsByIsbnBookService = existsByIsbnBookService;
    }

    public void execute(final Book book, final Long authorId, final Long categoryId) throws ServiceException {
        try {
            checkIfTitleExists(book.getTitle());
            checkIfIsbnExists(book.getIsbn());
            findAndSetIdAuthorInObjectBook(book, authorId);
            findAndSetIdCategoryInObjectBook(book, categoryId);

            createBookGateway.execute(book);
        } catch (CreateBookGatewayException e) {
            throw new CreateBookServiceException("Problemas ao criar um novo livro", e.getCause());
        }
    }

    private void checkIfTitleExists(String title) throws ExistsByTitleBookServiceException {
        if (existsByTitleBookService.execute(title)) {
            throw new ExistsByTitleBookServiceException("Um livro com o título " + title + " já existe");
        }
    }

    private void checkIfIsbnExists(String isbn) throws ExistsByIsbnBookServiceException {
        if (existsByIsbnBookService.execute(isbn)) {
            throw new ExistsByIsbnBookServiceException("Um livro com o isbn: " + isbn + " já existe");
        }
    }

    private void findAndSetIdAuthorInObjectBook(Book book, Long authorId) {
        final Optional<AuthorDatabase> author = getAuthorByIdService.execute(authorId);
        book.setAuthor(author.orElse(null).getId());
    }

    private void findAndSetIdCategoryInObjectBook(Book book, Long categoryId) {
        final Optional<CategoryDatabase> category = getCategoryByIdGateway.execute(categoryId);
        book.setCategory(category.orElse(null).getId());
    }
}
