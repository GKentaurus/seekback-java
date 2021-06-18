package tech.seekback.dao.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Producto;

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
class ProductoDAOJPATest {
  @InjectMocks
  private ProductoDAOJPA daoMock;

  @Mock
  private EntityManager emMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @Disabled
  public void getCatCount() {
    TypedQuery queryMock = mock(TypedQuery.class);

    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getSingleResult()).thenReturn(anyInt());

    Integer count = this.daoMock.getCatCount(1);
    assertNotNull(count);
  }

  @Test
  public void getCatCountThrowsException() {
    Integer count;
    Exception exception = null;

    try {
      when(daoMock.getCatCount(1)).thenThrow(new Exception());
      count = daoMock.getCatCount(1);
    } catch (Exception e) {
      count = 0;
      exception = e;
    }

    assertEquals(0, count);
    assertNotNull(exception);
  }

  @Test
  public void getCategoryProducts() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);

    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setParameter(anyString(), any())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Producto> list = this.daoMock.getCategoryProducts(1);
    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getCategoryProductsThrowsException() {
    List<Producto> list = null;
    Exception exception = null;

    try {
      when(daoMock.getCategoryProducts(1)).thenThrow(new Exception());
      list = daoMock.getCategoryProducts(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }

  @Test
  public void getLastProducts() throws ConnectionExcep {
    TypedQuery queryMock = mock(TypedQuery.class);

    when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
    when(queryMock.setMaxResults(anyInt())).thenReturn(queryMock);
    when(queryMock.getResultList()).thenReturn(Collections.emptyList());

    List<Producto> list = this.daoMock.getLastProducts(1);
    assertNotNull(list);
    assertTrue(list.isEmpty());
  }

  @Test
  public void getLastProductsThrowsException() {
    List<Producto> list = null;
    Exception exception = null;

    try {
      when(daoMock.getLastProducts(1)).thenThrow(new Exception());
      list = daoMock.getLastProducts(1);
    } catch (Exception e) {
      exception = e;
    }

    assertNull(list);
    assertNotNull(exception);
  }
}
