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
import tech.seekback.models.Agenda;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class AgendaDAOJPATest {

  @InjectMocks
  private AgendaDAOJPA daoMock;

  @Mock
  private EntityManager emMock;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getByIdEmpleadoTest() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Agenda> list = daoMock.getByidEmpleado(1);

    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getByIdEmpleadoThrowExceptionTest() {
    List<Agenda> list = null;
    Exception exception = null;

    try {
      when(daoMock.getByidEmpleado(anyInt())).thenThrow(new Exception());
      list = daoMock.getByidEmpleado(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }

  @Test
  public void getByIdClienteTest() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Agenda> list = daoMock.getByidCliente(1);

    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getByIdClienteThrowExceptionTest() {
    List<Agenda> list = null;
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
