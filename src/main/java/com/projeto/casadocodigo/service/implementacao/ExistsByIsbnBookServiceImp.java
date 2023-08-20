package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.gateway.ExistsByIsbnBookGateway;
import com.projeto.casadocodigo.service.ExistsByIsbnBookService;
import com.projeto.casadocodigo.service.exception.ExistsByIsbnBookServiceException;
import org.springframework.stereotype.Service;

@Service
public class ExistsByIsbnBookServiceImp implements ExistsByIsbnBookService {
    private final ExistsByIsbnBookGateway existsByIsbnBookGateway;

    public ExistsByIsbnBookServiceImp(ExistsByIsbnBookGateway existsByIsbnBookGateway) {
        this.existsByIsbnBookGateway = existsByIsbnBookGateway;
    }

    @Override
    public boolean execute(final String isbn) throws ExistsByIsbnBookServiceException {
        try {
            return existsByIsbnBookGateway.execute(isbn);
        } catch (Exception e) {
            throw new ExistsByIsbnBookServiceException("Erro ao verificar isbn");
        }
    }
}
