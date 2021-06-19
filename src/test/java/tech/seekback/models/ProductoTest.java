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
class ProductoTest {

  @InjectMocks
  private Producto productoMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getId() {
    Integer id = 1;
    this.productoMock.setId(id);
    assertNotNull(this.productoMock.getId());
    assertEquals(id, this.productoMock.getId());
  }

  @Test
  void attributeModeloProductoTest() {
    String modelo = "QP-728MI";
    this.productoMock.setModeloProducto(modelo);
    assertNotNull(this.productoMock.getModeloProducto());
    assertEquals(modelo, this.productoMock.getModeloProducto());
  }

  @Test
  void attributeDescripcionTest() {
    String descripcion = "Descripción del producto";
    this.productoMock.setDescripcion(descripcion);
    assertNotNull(this.productoMock.getDescripcion());
    assertEquals(descripcion, this.productoMock.getDescripcion());
  }

  @Test
  void attributePrecioVentaTest() {
    Double precio = 100D;
    this.productoMock.setPrecioVenta(precio);
    assertNotNull(this.productoMock.getPrecioVenta());
    assertEquals(precio, this.productoMock.getPrecioVenta());
  }

  @Test
  void attributeCategoriaTest() {
    CategoriasProducto categoria = Mockito.mock(CategoriasProducto.class);
    this.productoMock.setCategoria(categoria);
    assertNotNull(this.productoMock.getCategoria());
    assertEquals(categoria, this.productoMock.getCategoria());
  }

  @Test
  void attributeEstadoTrueTest() {
    this.productoMock.setEstado(true);
    assertTrue(this.productoMock.getEstado());
  }

  @Test
  void attributeEstadoFastTest() {
    this.productoMock.setEstado(false);
    assertFalse(this.productoMock.getEstado());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.productoMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.productoMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Producto modelTest = new Producto();
    assertEquals(this.productoMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.productoMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Producto modelTest = new Producto();
    assertEquals(this.productoMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.productoMock.equals(this.productoMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Producto modelTest = new Producto();
    modelTest.setId(1);
    modelTest.setDescripcion("Descripción # 1");
    assertNotEquals(this.productoMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.productoMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.productoMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Producto modelTest = new Producto();
    modelTest.setTimestamps(tsMock);
    this.productoMock.setTimestamps(tsMock);
    assertEquals(this.productoMock.toString(), modelTest.toString());
  }
}
