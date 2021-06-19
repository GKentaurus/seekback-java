package tech.seekback.dao.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Telefono;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class TelefonoDAOJPATest {
  @InjectMocks
  private TelefonoDAOJPA daoMock;

  @Mock
  EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getByIdUsuario() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    Telefono telefonoMock = mock(Telefono.class);
    Integer id = 1;
    telefonoMock.setId(id);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(telefonoMock);

    Telefono telefono = daoMock.getByIdUsuario(1);

    assertNotNull(telefono);
//    assertEquals(id, telefono.getId());
  }

  @Test
  public void getByIdUsuarioThrowsException() {
    Telefono telefono = null;
    Exception exception = null;

    try {
      when(daoMock.getByIdUsuario(anyInt())).thenThrow(new Exception()).thenReturn(null);
      telefono = daoMock.getByIdUsuario(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(telefono);
    assertNotNull(exception);
  }

  @Test
  public void getByIdPrincipal() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    Telefono telefonoMock = mock(Telefono.class);
    Integer id = 1;
    telefonoMock.setId(id);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(telefonoMock);

    Telefono telefono = daoMock.getByIdPrincipal(1);

    assertNotNull(telefono);
//    assertEquals(id, telefono.getId());
  }

  @Test
  public void getByIdPrincipalThrowsNoResultException() {
    Telefono telefono = null;
    Exception exception = null;

    try {
      when(daoMock.getByIdPrincipal(anyInt())).thenThrow(new NoResultException()).thenReturn(null);
      telefono = daoMock.getByIdPrincipal(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(telefono);
    assertNotNull(exception);
  }

  @Test
  public void getByIdPrincipalThrowsConnectionExcep() {
    Telefono telefono = null;
    Exception exception = null;

    try {
      when(daoMock.getByIdPrincipal(anyInt())).thenThrow(new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION));
      telefono = daoMock.getByIdPrincipal(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(telefono);
    assertNotNull(exception);
  }

}
