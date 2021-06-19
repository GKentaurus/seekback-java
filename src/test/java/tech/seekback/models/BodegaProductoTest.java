package tech.seekback.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.seekback.models.templates.Timestamps;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class BodegaProductoTest {

  @InjectMocks
  private BodegaProducto bpMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.bpMock.setId(id);
    assertNotNull(this.bpMock.getId());
    assertEquals(id, this.bpMock.getId());
  }

  @Test
  void attributeBodegaTest() {
    Bodega bodega = Mockito.mock(Bodega.class);
    this.bpMock.setBodega(bodega);
    assertNotNull(this.bpMock.getBodega());
    assertEquals(bodega, this.bpMock.getBodega());
  }

  @Test
  void attributeProductoTest() {
    Producto producto = Mockito.mock(Producto.class);
    this.bpMock.setProducto(producto);
    assertNotNull(this.bpMock.getProducto());
    assertEquals(producto, this.bpMock.getProducto());
  }

  @Test
  void attributeCantidadTest() {
    Integer cantidad = 100;
    this.bpMock.setCantidad(cantidad);
    assertNotNull(this.bpMock.getCantidad());
    assertEquals(cantidad, this.bpMock.getCantidad());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.bpMock.setTimestamps(tsMock);
    assertNotNull(this.bpMock.getTimestamps());
    assertEquals(tsMock, this.bpMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    BodegaProducto modelTest = new BodegaProducto();
    assertEquals(this.bpMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.bpMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    BodegaProducto modelTest = new BodegaProducto();
    assertEquals(this.bpMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.bpMock.equals(this.bpMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    BodegaProducto modelTest = new BodegaProducto();
    modelTest.setId(1);
    modelTest.setCantidad(100);
    assertNotEquals(this.bpMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.bpMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.bpMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    BodegaProducto modelTest = new BodegaProducto();
    modelTest.setTimestamps(tsMock);
    this.bpMock.setTimestamps(tsMock);
    assertEquals(this.bpMock.toString(), modelTest.toString());
  }
}
