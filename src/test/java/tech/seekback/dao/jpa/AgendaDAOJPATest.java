package tech.seekback.dao.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Agenda;
import org.junit.platform.runner.JUnitPlatform;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class AgendaDAOJPATest {

  @InjectMocks
  private AgendaDAOJPA agendaDaoMock = new AgendaDAOJPA();

  @Mock
  private EntityManager emMock;

  @Test
  public void getByIdEmpleadoTest() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Agenda> list = agendaDaoMock.getByidEmpleado(1);

    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getByIdEmpleadoThrowExceptionTest() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenThrow(new Exception());
    List<Agenda> list = null;
    Exception exception = null;
    try {
      list = agendaDaoMock.getByidEmpleado(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
    assertEquals(ConnectionExcep.class, exception.getClass());
  }
}
