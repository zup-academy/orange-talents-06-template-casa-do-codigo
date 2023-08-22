package com.projeto.casadocodigo.service.implementacao;

import com.projeto.casadocodigo.domain.author.Author;
import com.projeto.casadocodigo.domain.author.AuthorBuilder;
import com.projeto.casadocodigo.gateway.CreateAuthorGateway;
import com.projeto.casadocodigo.gateway.exception.CreateAuthorGatewayException;
import com.projeto.casadocodigo.gateway.exception.GatewayException;
import com.projeto.casadocodigo.service.ExistsByEmailService;
import com.projeto.casadocodigo.service.exception.CreateAuthorServiceException;
import com.projeto.casadocodigo.service.exception.ServiceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Serviço de criação de autor")
public class CreateAuthorServiceImpTest {

    @Mock
    private CreateAuthorGateway createAuthorGateway;
    @Mock
    private ExistsByEmailService existsByEmailService;
    @InjectMocks
    private CreateAuthorServiceImp createAuthorServiceImp;

    @Test
    @DisplayName("Deve criar um autor com dados válidos")
    public void createValidAuthor() throws GatewayException, ServiceException {
        Author validAuthor = AuthorBuilder.anAuthor().build();

        when(existsByEmailService.execute(validAuthor.getEmail())).thenReturn(false);

        createAuthorServiceImp.execute(validAuthor);

        verify(createAuthorGateway, times(1)).execute(validAuthor);
    }

    @Test
    @DisplayName("Deve verificar se recebeu corretamente um author válido")
    public void verificaSeServicoRecebeuCorretamenteUmAuthor() throws GatewayException, ServiceException {
        Author author = AuthorBuilder.anAuthor().build();

        when(existsByEmailService.execute(author.getEmail())).thenReturn(false);
        doNothing().when(createAuthorGateway).execute(author);
        assertDoesNotThrow(() -> createAuthorServiceImp.execute(author));

        verify(existsByEmailService, times(1)).execute(author.getEmail());
        verify(createAuthorGateway, times(1)).execute(author);
        verifyNoMoreInteractions(createAuthorGateway);
    }

    @Test
    @DisplayName("Deve lançar a excessão correta caso e-mail já exista")
    public void lancaExcessaoExistEmailServiceExceptionCasoEmailJaExista() throws ServiceException, GatewayException {
        Author author = AuthorBuilder.anAuthor().build();
        when(existsByEmailService.execute(author.getEmail())).thenReturn(true);
        CreateAuthorServiceException ex = assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(author));

        assertTrue(ex.getMessage().contains("já foi cadastrado por outro autor"));
        verifyNoInteractions(createAuthorGateway);
        verify(createAuthorGateway, never()).execute(author);
    }

    @Test
    @DisplayName("Deve rejeitar usuario com nome vazio")
    public void rejectInvalidUserByEmptyName() throws GatewayException, ServiceException {

        Author authorWithEmptyName = AuthorBuilder.anAuthor().withName("").build();
        Author author = AuthorBuilder.anAuthor().build();

        when(existsByEmailService.execute(author.getEmail())).thenReturn(false);

        doThrow(CreateAuthorGatewayException.class).when(createAuthorGateway).execute(authorWithEmptyName);

        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithEmptyName), "Must throw CreateAuthorServiceException for empty name");

        verify(createAuthorGateway, times(1)).execute(authorWithEmptyName);
    }

    @Test
    @DisplayName("Deve rejeitar usuário com nome nulo")
    public void rejectInvalidUserByNullName() throws ServiceException, GatewayException {
        Author authorWithNullName = AuthorBuilder.anAuthor().withName(null).build();
        Author author = AuthorBuilder.anAuthor().build();

        when(existsByEmailService.execute(author.getEmail())).thenReturn(false);

        doThrow(CreateAuthorGatewayException.class).when(createAuthorGateway).execute(authorWithNullName);

        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithNullName));

        verify(createAuthorGateway, times(1)).execute(authorWithNullName);
    }

    @Test
    @DisplayName("Deve rejeitar usuario com email vazio")
    public void rejectInvalidUserByEmptyEmail() throws GatewayException, ServiceException {
        Author authorWithEmptyEmail = AuthorBuilder.anAuthor().withEmail("").build();

        when(existsByEmailService.execute(authorWithEmptyEmail.getEmail())).thenReturn(false);

        doThrow(CreateAuthorGatewayException.class).when(createAuthorGateway).execute(authorWithEmptyEmail);


        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithEmptyEmail), "Must throw CreateAuthorServiceException for empty email");

        verify(createAuthorGateway, times(1)).execute(authorWithEmptyEmail);
    }
    @Test
    @DisplayName("Deve rejeitar usuario com email nulo")
    public void rejectInvalidUserByNullEmail() throws GatewayException, ServiceException {
        Author authorWithNullEmail = AuthorBuilder.anAuthor().withEmail(null).build();

        when(existsByEmailService.execute(authorWithNullEmail.getEmail())).thenReturn(false);

        doThrow(CreateAuthorGatewayException.class).when(createAuthorGateway).execute(authorWithNullEmail);

        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithNullEmail));

        verify(createAuthorGateway, times(1)).execute(authorWithNullEmail);
    }

    @Test
    @DisplayName("Deve rejeitar usuario com descricao vazio")
    public void rejectInvalidUserByEmptyDescription() throws GatewayException, ServiceException {
        Author authorWithEmptyDescription = AuthorBuilder.anAuthor().withDescription("").build();
        Author author = AuthorBuilder.anAuthor().build();

        when(existsByEmailService.execute(author.getEmail())).thenReturn(false);

        doThrow(CreateAuthorGatewayException.class).when(createAuthorGateway).execute(authorWithEmptyDescription);

        CreateAuthorServiceException exceptionWithEmptyDescription = assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithEmptyDescription), "Must throw CreateAuthorServiceException for empty description");
        assertEquals("Problemas ao criar Author", exceptionWithEmptyDescription.getMessage());

        verify(createAuthorGateway, times(1)).execute(authorWithEmptyDescription);
    }
    @Test
    @DisplayName("Deve rejeitar usuario com descricao nulo")
    public void rejectInvalidUserByEmptyNullDescription() throws GatewayException, ServiceException {
        Author authorWithNullDescription = AuthorBuilder.anAuthor().withDescription(null).build();
        Author author = AuthorBuilder.anAuthor().build();

        when(existsByEmailService.execute(author.getEmail())).thenReturn(false);

        doThrow(CreateAuthorGatewayException.class).when(createAuthorGateway).execute(authorWithNullDescription);

        CreateAuthorServiceException exceptionWithNullDescription = assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(authorWithNullDescription), "Must throw CreateAuthorServiceException for null description");
        assertEquals("Problemas ao criar Author", exceptionWithNullDescription.getMessage());

        verify(createAuthorGateway, times(1)).execute(authorWithNullDescription);
    }

    @Test
    @DisplayName("Deve lançar CreateAuthorServiceException quando ocorrer erro na criação de autor")
    public void ThrowsCreateAuthorServiceExceptionWhenErrorOccursWhileCreatingAuthor() throws GatewayException {
        Author author = AuthorBuilder.anAuthor().build();

        doThrow(CreateAuthorGatewayException.class).when(createAuthorGateway).execute(author);

        assertThrows(CreateAuthorServiceException.class, () -> createAuthorServiceImp.execute(author));

        verify(createAuthorGateway, times(1)).execute(author);
    }
}