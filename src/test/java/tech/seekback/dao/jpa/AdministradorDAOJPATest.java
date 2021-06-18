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
class AdministradorDAOJPATest {

  @InjectMocks
  private AdministradorDAOJPA daoMock;

  @Mock
  private EntityManager emMock;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getOneTest() throws Exception {
    TypedQuery queryMock = mock(TypedQuery.class);
    Usuario adminstradorMock = new Usuario();
    Integer id = 1;
    adminstradorMock.setId(id);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), anyInt())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(adminstradorMock);

    Usuario administrador = daoMock.getOne(id);

    assertNotNull(administrador);
//    assertEquals(id, administrador.getId());
  }

  @Test
  public void getOneThrowExceptionTest() {
    Usuario administrador = null;
    Exception exception = null;

    try {
      when(daoMock.getOne(anyInt())).thenThrow(new Exception());
      administrador = daoMock.getOne(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(administrador);
    assertNotNull(exception);
  }

  @Test
  public void getAllTest() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Usuario> administradores = daoMock.getAll();

    assertNotNull(administradores);
    assertTrue(administradores.isEmpty());
  }

  @Test
  public void getAllThrowExceptionTest() {
    List<Usuario> administradores = null;
    Exception exception = null;

    try {
      when(daoMock.getAll()).thenThrow(new Exception());
      administradores = daoMock.getAll();
    } catch (Exception e) {
      exception = e;
    }

    assertNull(administradores);
    assertNotNull(exception);
  }
}
