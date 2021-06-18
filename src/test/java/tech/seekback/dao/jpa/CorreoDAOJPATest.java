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
import tech.seekback.models.Correo;

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
class CorreoDAOJPATest {
  @InjectMocks
  private CorreoDAOJPA daoMock;

  @Mock
  EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getByCorreo() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    Correo correoMock = mock(Correo.class);
    Integer id = 1;
    correoMock.setId(id);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyString())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(correoMock);

    Correo correo = daoMock.getByCorreo("correo@correo.com");

    assertNotNull(correo);
//    assertEquals(id, correo.getId());
  }

  @Test
  public void getByCorreoThrowsNoResultException() {
    Correo correo = null;
    Exception exception = null;

    try {
      when(daoMock.getByCorreo(anyString())).thenThrow(new NoResultException()).thenReturn(null);
      correo = daoMock.getByCorreo("correo@correo.com");
    } catch (Exception e) {
      exception = e;
    }

    assertNull(correo);
    assertNotNull(exception);
  }

  @Test
  public void getByCorreoThrowsConnectionExcep() {
    Correo correo = null;
    Exception exception = null;

    try {
      when(daoMock.getByCorreo(anyString())).thenThrow(new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION));
      correo = daoMock.getByCorreo("correo@correo.com");
    } catch (Exception e) {
      exception = e;
    }

    assertNull(correo);
    assertNotNull(exception);
  }

  @Test
  public void getByIdPrincipal() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    Correo correoMock = mock(Correo.class);
    Integer id = 1;
    correoMock.setId(id);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(correoMock);

    Correo correo = daoMock.getByIdPrincipal(1);

    assertNotNull(correo);
//    assertEquals(id, correo.getId());
  }

  @Test
  public void getByIdPrincipalThrowsNoResultException() {
    Correo correo = null;
    Exception exception = null;

    try {
      when(daoMock.getByIdPrincipal(anyInt())).thenThrow(new NoResultException()).thenReturn(null);
      correo = daoMock.getByIdPrincipal(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(correo);
    assertNotNull(exception);
  }

  @Test
  public void getByIdPrincipalThrowsConnectionExcep() {
    Correo correo = null;
    Exception exception = null;

    try {
      when(daoMock.getByIdPrincipal(anyInt())).thenThrow(new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION));
      correo = daoMock.getByIdPrincipal(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(correo);
    assertNotNull(exception);
  }
}
