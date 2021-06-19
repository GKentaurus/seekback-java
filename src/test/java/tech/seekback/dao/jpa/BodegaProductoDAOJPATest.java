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
import tech.seekback.models.BodegaProducto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class BodegaProductoDAOJPATest {
  @InjectMocks
  private BodegaProductoDAOJPA daoMock;

  @Mock
  EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getByIdCategoriaTest() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);
    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<BodegaProducto> bodegaProductos = this.daoMock.getByIdCategoria(1);
    assertNotNull(bodegaProductos);
    assertTrue(bodegaProductos.isEmpty());
  }

  @Test
  public void getByIdCategoriaTestThrowsException() {
    List<BodegaProducto> list = null;
    Exception exception = null;

    try {
      list = daoMock.getByIdCategoria(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }

  @Test
  public void getByIdProductoTest() throws Exception {
    TypedQuery queryMock = mock(TypedQuery.class);
    BodegaProducto bodegaProductoMock = mock(BodegaProducto.class);
    Integer id = 1;
    bodegaProductoMock.setId(1);

    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(bodegaProductoMock);

    BodegaProducto bodegaProducto = this.daoMock.getByIdProducto(1);

    assertNotNull(bodegaProducto);
//    assertEquals(id, bodegaProducto.getId());
  }

  @Test
  public void getByIdProductoTestThrowsException() {
    BodegaProducto bodegaProducto = null;
    Exception exception = null;

    try {
      bodegaProducto = this.daoMock.getByIdProducto(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(bodegaProducto);
    assertNotNull(exception);
  }
}
