package tech.seekback.dao.jpa;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.seekback.models.Direccion;

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
class DireccionDAOJPATest {
  @InjectMocks
  private DireccionDAOJPA daoMock;

  @Mock
  private EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @SneakyThrows
  @Test
  public void getByIdPrincipal() {
    TypedQuery queryMock = mock(TypedQuery.class);
    Direccion direccionMock = mock(Direccion.class);
    Integer id = 1;

    direccionMock.setId(id);

    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(direccionMock);

    Direccion direccion = this.daoMock.getByIdPrincipal(1);
    assertNotNull(direccion);
//    assertEquals(id, direccion.getId());
  }

  @Test
  public void getByIdPrincipalThrowsConnectionExcep() {
    Direccion direccion = null;
    Exception exception = null;

    try {
      when(daoMock.getByIdPrincipal(anyInt())).thenThrow(new Exception());
      direccion = daoMock.getByIdPrincipal(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(direccion);
    assertNotNull(exception);
  }

  @Test
  public void getByIdPrincipalThrowsNoResultException() {
    Direccion direccion = null;
    Exception exception = null;

    try {
      when(daoMock.getByIdPrincipal(anyInt())).thenThrow(new NoResultException()).thenReturn(null);
      direccion = daoMock.getByIdPrincipal(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(direccion);
    assertNotNull(exception);
  }
}
