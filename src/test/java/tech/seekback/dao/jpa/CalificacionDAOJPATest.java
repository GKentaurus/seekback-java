package tech.seekback.dao.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Calificacion;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalificacionDAOJPATest {
  @InjectMocks
  private CalificacionDAOJPA daoMock;

  @Mock
  private EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getByIdProducto() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Calificacion> list = this.daoMock.getByIdProducto(1);
    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getByIdProductoThrowsException() {
    List<Calificacion> list = null;
    Exception exception = null;

    try {
      list = daoMock.getByIdProducto(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }

  @Test
  public void getByidCliente() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Calificacion> list = this.daoMock.getByidCliente(1);
    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getByidClienteThrowsException() {
    List<Calificacion> list = null;
    Exception exception = null;

    try {
      list = daoMock.getByidCliente(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }

  @Test
  @Disabled
  void getCalCountId() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(1);

    Integer count = this.daoMock.getCalCountId(1);
    assertNotNull(count);
  }

  @Test
  public void getCalCountIdThrowsException() {
    Integer count = null;
    Exception exception = null;

    try {
      count = daoMock.getCalCountId(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(count);
    assertNotNull(exception);
  }
}
