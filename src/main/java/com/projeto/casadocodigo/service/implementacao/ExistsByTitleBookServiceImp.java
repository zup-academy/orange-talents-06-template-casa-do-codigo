package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.gateway.ExistsByTitleBookGateway;
import com.projeto.casadocodigo.service.ExistsByTitleBookService;
import com.projeto.casadocodigo.service.exception.ExistsByTitleBookServiceException;
import org.springframework.stereotype.Service;

@Service
public class ExistsByTitleBookServiceImp implements ExistsByTitleBookService {

    private final ExistsByTitleBookGateway existsByTitleBookGateway;

    public ExistsByTitleBookServiceImp(ExistsByTitleBookGateway existsByTitleBookGateway) {
        this.existsByTitleBookGateway = existsByTitleBookGateway;
    }

    @Override
    public boolean execute(String title) throws ExistsByTitleBookServiceException {
        try {
            return existsByTitleBookGateway.execute(title);
        } catch (Exception e) {
            throw new ExistsByTitleBookServiceException("Erro ao verificar titulo");
        }

    }
}
