package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.domain.author.AuthorBuilder;
import com.projeto.casadocodigo.gateway.CreateAuthorGateway;
import com.projeto.casadocodigo.gateway.exception.CreateGatewayException;
import com.projeto.casadocodigo.service.exception.CreateAuthorServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Serviço de criação de autor")
public class CreateAuthorServiceImpTest {

    @Mock
    private CreateAuthorGateway createAuthorGateway;
    @InjectMocks
    private CreateAuthorServiceImp createAuthorServiceImp;

    @Test
    @DisplayName("Deve verificar se recebeu corretamente um author válido")
    public void verificaSeServicoRecebeuCorretamenteUmAuthor() throws CreateGatewayException {
        Author author = AuthorBuilder.anAuthor().build();

        doNothing().when(createAuthorGateway).execute(author);
        assertDoesNotThrow(() -> createAuthorServiceImp.execute(author));

        verify(createAuthorGateway, times(1)).execute(author);
        verifyNoMoreInteractions(createAuthorGateway);
    }

    @Test
    @DisplayName("Deve rejeitar usuario com nome vazio ou nulo")
    public void rejectInvalidUserByNome() throws CreateGatewayException {
        // Crie o Author inválido fora do CreateAuthorGateway, diretamente no teste
        Author authorWithEmptyName = AuthorBuilder.anAuthor().withName("").build();
        Author authorWithNullName = AuthorBuilder.anAuthor().withName(null).build();

        // Simule o comportamento do CreateAuthorGateway no serviço
        doThrow(CreateGatewayException.class).when(createAuthorGateway).execute(authorWithEmptyName);
        doThrow(CreateGatewayException.class).when(createAuthorGateway).execute(authorWithNullName);

        // Chame o serviço que deve usar o CreateAuthorGateway internamente
        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithEmptyName), "Must throw CreateAuthorServiceException for empty name");
        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithNullName), "Must throw CreateAuthorServiceException for null name");


        // Verifique se o CreateAuthorGateway foi chamado corretamente
        verify(createAuthorGateway, times(1)).execute(authorWithEmptyName);
        verify(createAuthorGateway, times(1)).execute(authorWithNullName);
    }

    @Test
    @DisplayName("Deve rejeitar usuario com email vazio ou nulo")
    public void rejectInvalidUserByEmail() throws CreateGatewayException {
        Author authorWithEmptyEmail = AuthorBuilder.anAuthor().withEmail("").build();
        Author authorWithNullEmail = AuthorBuilder.anAuthor().withEmail(null).build();

        doThrow(CreateGatewayException.class).when(createAuthorGateway).execute(authorWithEmptyEmail);
        doThrow(CreateGatewayException.class).when(createAuthorGateway).execute(authorWithNullEmail);

        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithEmptyEmail), "Must throw CreateAuthorServiceException for empty email");
        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithNullEmail), "Must throw CreateAuthorServiceException for null email");

        verify(createAuthorGateway, times(1)).execute(authorWithEmptyEmail);
        verify(createAuthorGateway, times(1)).execute(authorWithNullEmail);
    }


    @Test
    @DisplayName("Deve rejeitar usuario com descricao vazio ou nulo")
    public void rejectInvalidUserByDescription() throws CreateGatewayException {
        Author authorWithEmptyDescription = AuthorBuilder.anAuthor().withDescription("").build();
        Author authorWithNullDescription = AuthorBuilder.anAuthor().withDescription(null).build();

        doThrow(CreateGatewayException.class).when(createAuthorGateway).execute(authorWithEmptyDescription);
        doThrow(CreateGatewayException.class).when(createAuthorGateway).execute(authorWithNullDescription);

        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithEmptyDescription), "Must throw CreateAuthorServiceException for empty description");
        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithNullDescription), "Must throw CreateAuthorServiceException for null description");

        verify(createAuthorGateway, times(1)).execute(authorWithEmptyDescription);
        verify(createAuthorGateway, times(1)).execute(authorWithNullDescription);
    }

    @Test
    @DisplayName("Verifica se injeção de dependência recebe obejeto correto")
    public void verifyDependecyInjection() throws CreateGatewayException {
        CreateAuthorServiceImp createAuthorServiceImp = new CreateAuthorServiceImp(createAuthorGateway);
        assertNotNull(createAuthorServiceImp);
    }

    @Test
    @DisplayName("Deve lançar CreateAuthorServiceException quando ocorrer erro na criação de autor")
    public void ThrowsCreateAuthorServiceExceptionWhenErrorOccursWhileCreatingAuthor() throws CreateGatewayException {
        // Crie um Author qualquer para usar como parâmetro no serviço
        Author author = AuthorBuilder.anAuthor().build();

        // Simule o comportamento do CreateAuthorGateway lançando a exceção CreateGatewayException
        doThrow(CreateGatewayException.class).when(createAuthorGateway).execute(author);

        // Chame o serviço e verifique se ele lança a exceção CreateAuthorServiceException
        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(author));

        // Verifique se o CreateAuthorGateway foi chamado corretamente
        verify(createAuthorGateway, times(1)).execute(author);
    }
}