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
import tech.seekback.models.SoporteTecnico;

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
class SoporteTecnicoDAOJPATest {
  @InjectMocks
  private SoporteTecnicoDAOJPA daoMock;

  @Mock
  private EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getAllCount() throws Exception {
    TypedQuery queryMock = mock(TypedQuery.class);

    when(emMock.createNamedQuery(anyString())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(anyInt());
    when(this.daoMock.getAllCount()).thenReturn(1);

    Integer count = this.daoMock.getAllCount();
    assertNotNull(count);
    assertNotEquals(0, count);
  }

  @Test
  public void getAllCountThrowsException() {
    Integer count = null;
    Exception exception = null;

    try {
      count = daoMock.getAllCount();
    } catch (Exception e) {
      exception = e;
    }

    assertNull(count);
    assertNotNull(exception);
  }

  @Test
  public void getByidEmpleado() throws Exception {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<SoporteTecnico> list = this.daoMock.getByidEmpleado(1);
    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getByidEmpleadoThrowsException() {
    List<SoporteTecnico> list = null;
    Exception exception = null;

    try {
      when(daoMock.getByidEmpleado(anyInt())).thenThrow(new ConnectionExcep(ConnectionExcepEnum.ERROR_CONEXION));
      list = daoMock.getByidEmpleado(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }

  @Test
  public void getByidCliente() throws Exception {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<SoporteTecnico> list = this.daoMock.getByidCliente(1);
    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getByidClienteThrowsException() {
    List<SoporteTecnico> list = null;
    Exception exception = null;

    try {
      when(daoMock.getByidCliente(anyInt())).thenThrow(new Exception());
      list = daoMock.getByidCliente(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }
}
