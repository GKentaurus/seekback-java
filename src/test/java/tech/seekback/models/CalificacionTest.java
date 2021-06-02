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
class CalificacionTest {

  @InjectMocks
  private Calificacion calificacionMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.calificacionMock.setId(id);
    assertNotNull(this.calificacionMock.getId());
    assertEquals(id, this.calificacionMock.getId());
  }

  @Test
  void attributeProductoTest() {
    Producto producto = Mockito.mock(Producto.class);
    this.calificacionMock.setProducto(producto);
    assertNotNull(this.calificacionMock.getProducto());
    assertEquals(producto, this.calificacionMock.getProducto());
  }

  @Test
  void attributeCalificacionTest() {
    Integer calificacion = 5;
    this.calificacionMock.setCalificacion(calificacion);
    assertNotNull(this.calificacionMock.getCalificacion());
    assertEquals(calificacion, this.calificacionMock.getCalificacion());
  }

  @Test
  void attributeClienteTest() {
    Usuario cliente = Mockito.mock(Usuario.class);
    this.calificacionMock.setCliente(cliente);
    assertNotNull(this.calificacionMock.getCliente());
    assertEquals(cliente, this.calificacionMock.getCliente());
  }

  @Test
  void attributeComentarioTest() {
    String comentario = "Comentario de la calificación";
    this.calificacionMock.setComentario(comentario);
    assertNotNull(this.calificacionMock.getComentario());
    assertEquals(comentario, this.calificacionMock.getComentario());
  }

  @Test
  void attributeEsAprobadoTrueTest() {
    this.calificacionMock.setEsAprobado(true);
    assertNotNull(this.calificacionMock.getEsAprobado());
    assertTrue(this.calificacionMock.getEsAprobado());
  }

  @Test
  void attributeEsAprobadoFalseTest() {
    this.calificacionMock.setEsAprobado(false);
    assertNotNull(this.calificacionMock.getEsAprobado());
    assertFalse(this.calificacionMock.getEsAprobado());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.calificacionMock.setTimestamps(tsMock);
    assertNotNull(this.calificacionMock.getTimestamps());
    assertEquals(tsMock, this.calificacionMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Calificacion modelTest = new Calificacion();
    assertEquals(this.calificacionMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.calificacionMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Calificacion modelTest = new Calificacion();
    assertEquals(this.calificacionMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.calificacionMock.equals(this.calificacionMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Calificacion modelTest = new Calificacion();
    modelTest.setId(1);
    modelTest.setCalificacion(5);
    assertNotEquals(this.calificacionMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.calificacionMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.calificacionMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Calificacion modelTest = new Calificacion();
    modelTest.setTimestamps(tsMock);
    this.calificacionMock.setTimestamps(tsMock);
    assertEquals(this.calificacionMock.toString(), modelTest.toString());
  }
}

