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

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class SoporteTecnicoTest {
  @InjectMocks
  private SoporteTecnico stMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.stMock.setId(id);
    assertNotNull(this.stMock.getId());
    assertEquals(id, this.stMock.getId());
  }

  @Test
  void attributeProductoTest() {
    Producto producto = Mockito.mock(Producto.class);
    this.stMock.setProducto(producto);
    assertNotNull(this.stMock.getProducto());
    assertEquals(producto, this.stMock.getProducto());
  }

  @Test
  void attributeEstadoTest() {
    EstadosFidelizacion estado = Mockito.mock(EstadosFidelizacion.class);
    this.stMock.setEstado(estado);
    assertNotNull(this.stMock.getEstado());
    assertEquals(estado, this.stMock.getEstado());
  }

  @Test
  void attributeClienteTest() {
    Usuario cliente = Mockito.mock(Usuario.class);
    this.stMock.setCliente(cliente);
    assertNotNull(this.stMock.getCliente());
    assertEquals(cliente, this.stMock.getCliente());
  }

  @Test
  void attributeEmpleadoTest() {
    Usuario empleado = Mockito.mock(Usuario.class);
    this.stMock.setEmpleado(empleado);
    assertNotNull(this.stMock.getEmpleado());
    assertEquals(empleado, this.stMock.getEmpleado());
  }

  @Test
  void attributeComentarioTest() {
    String comentario = "Comentario";
    this.stMock.setComentario(comentario);
    assertNotNull(this.stMock.getComentario());
    assertEquals(comentario, this.stMock.getComentario());
  }

  @Test
  void attributeFechaRespuestaTest() {
    Date fecha = new Date();
    this.stMock.setFechaRespuesta(fecha);
    assertNotNull(this.stMock.getFechaRespuesta());
    assertEquals(fecha, this.stMock.getFechaRespuesta());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.stMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.stMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    SoporteTecnico modelTest = new SoporteTecnico();
    assertEquals(this.stMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.stMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    SoporteTecnico modelTest = new SoporteTecnico();
    assertEquals(this.stMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.stMock.equals(this.stMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    SoporteTecnico modelTest = new SoporteTecnico();
    modelTest.setId(1);
    modelTest.setFechaRespuesta(new Date());
    assertNotEquals(this.stMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.stMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.stMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    SoporteTecnico modelTest = new SoporteTecnico();
    modelTest.setTimestamps(tsMock);
    this.stMock.setTimestamps(tsMock);
    assertEquals(this.stMock.toString(), modelTest.toString());
  }
}
