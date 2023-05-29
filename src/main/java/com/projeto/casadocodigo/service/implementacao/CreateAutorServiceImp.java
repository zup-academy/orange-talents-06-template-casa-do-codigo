package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.autor.Autor;
import com.projeto.casadocodigo.gateway.CreateAutorGateway;
import com.projeto.casadocodigo.gateway.exception.CreateGatewayException;
import com.projeto.casadocodigo.service.CreateAutorService;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.springframework.stereotype.Service;


@Service
public class CreateAutorServiceImp implements CreateAutorService {
    private final CreateAutorGateway createAutorGateway;
    public CreateAutorServiceImp(CreateAutorGateway createAutorGateway) {
        this.createAutorGateway = createAutorGateway;
    }

    public void execute(final Autor autor){
        try{
             createAutorGateway.execute(autor);
        }catch(CreateGatewayException e){
            throw new ServiceException("Problemas ao criar autor", e);
        }
    }
}
