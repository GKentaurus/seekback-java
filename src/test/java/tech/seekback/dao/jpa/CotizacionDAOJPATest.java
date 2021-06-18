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
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class CotizacionDAOJPATest {
  @InjectMocks
  private CotizacionDAOJPA daoMock;

  @Mock
  private EntityManager emMock;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getByIdEmpleado() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Cotizacion> list = daoMock.getByIdEmpleado(1);

    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getByIdempleadoThrowsException() {
    List<Cotizacion> list = null;
    Exception exception = null;

    try {
      when(daoMock.getByIdEmpleado(anyInt())).thenThrow(new Exception());
      list = daoMock.getByIdEmpleado(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }

  @Test
  public void getByIdCliente() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Cotizacion> list = daoMock.getByIdCliente(1);

    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getByIdClienteThrowsException() {
    List<Cotizacion> list = null;
    Exception exception = null;

    try {
      when(daoMock.getByIdCliente(anyInt())).thenThrow(new Exception());
      list = daoMock.getByIdCliente(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }
}
