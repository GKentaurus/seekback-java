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
import tech.seekback.models.Usuario;

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
class EmpleadoDAOJPATest {
  @InjectMocks
  private EmpleadoDAOJPA daoMock;

  @Mock
  EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getOne() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    Usuario empleadoMock = new Usuario();
    Integer id = 1;
    empleadoMock.setId(id);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(empleadoMock);

    Usuario empleado = daoMock.getOne(id);

    assertNotNull(empleado);
//    assertEquals(id, empleado.getId());
  }

  @Test
  public void getOneThrowsException() {
    Usuario empleado = null;
    Exception exception = null;

    try {
      when(daoMock.getOne(anyInt())).thenThrow(new Exception());
      empleado = daoMock.getOne(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(empleado);
    assertNotNull(exception);
  }

  @Test
  public void getAll() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Usuario> empleados = daoMock.getAll();

    assertNotNull(empleados);
    assertTrue(empleados.isEmpty());
  }

  @Test
  public void getAllThrowsException() {
    List<Usuario> empleados = null;
    Exception exception = null;

    try {
      when(daoMock.getAll()).thenThrow(new Exception());
      empleados = daoMock.getAll();
    } catch (Exception e) {
      exception = e;
    }

    assertNull(empleados);
    assertNotNull(exception);
  }
}
