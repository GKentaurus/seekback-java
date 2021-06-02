package tech.seekback.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tech.seekback.models.templates.Timestamps;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CotizacionTest {

  @InjectMocks
  private Cotizacion cotizacionMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.cotizacionMock.setId(id);
    assertNotNull(this.cotizacionMock.getId());
    assertEquals(id, this.cotizacionMock.getId());
  }

  @Test
  void attributeRequerimientoTest() {
    String requerimiento = "Requerimiento";
    this.cotizacionMock.setRequerimiento(requerimiento);
    assertNotNull(this.cotizacionMock.getRequerimiento());
    assertEquals(requerimiento, this.cotizacionMock.getRequerimiento());
  }

  @Test
  void attributeFechaTest() {
    Date fecha = new Date();
    this.cotizacionMock.setFecha(fecha);
    assertNotNull(this.cotizacionMock.getFecha());
    assertEquals(fecha, this.cotizacionMock.getFecha());
  }

  @Test
  void attributeVencimientoTest() {
    Date vencimiento = new Date();
    this.cotizacionMock.setVencimiento(vencimiento);
    assertNotNull(this.cotizacionMock.getVencimiento());
    assertEquals(vencimiento, this.cotizacionMock.getVencimiento());
  }

  @Test
  void attributeTrmTest() {
    TRM trm = Mockito.mock(TRM.class);
    this.cotizacionMock.setTrm(trm);
    assertNotNull(this.cotizacionMock.getTrm());
    assertEquals(trm, this.cotizacionMock.getTrm());
  }

  @Test
  void attributeEstadoTest() {
    EstadosCotizacion estadosCotizacion = Mockito.mock(EstadosCotizacion.class);
    this.cotizacionMock.setEstado(estadosCotizacion);
    assertNotNull(this.cotizacionMock.getEstado());
    assertEquals(estadosCotizacion, this.cotizacionMock.getEstado());
  }

  @Test
  void attributeEmpleadoTest() {
    Usuario empleado = Mockito.mock(Usuario.class);
    this.cotizacionMock.setEmpleado(empleado);
    assertNotNull(this.cotizacionMock.getEmpleado());
    assertEquals(empleado, this.cotizacionMock.getEmpleado());
  }

  @Test
  void attributeClienteTest() {
    Usuario cliente = Mockito.mock(Usuario.class);
    this.cotizacionMock.setCliente(cliente);
    assertNotNull(this.cotizacionMock.getCliente());
    assertEquals(cliente, this.cotizacionMock.getCliente());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.cotizacionMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.cotizacionMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Cotizacion modelTest = new Cotizacion();
    assertEquals(this.cotizacionMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.cotizacionMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Cotizacion modelTest = new Cotizacion();
    assertEquals(this.cotizacionMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.cotizacionMock.equals(this.cotizacionMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Cotizacion modelTest = new Cotizacion();
    modelTest.setId(1);
    modelTest.setRequerimiento("Requerimiento # 1");
    assertNotEquals(this.cotizacionMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.cotizacionMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.cotizacionMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Cotizacion modelTest = new Cotizacion();
    modelTest.setTimestamps(tsMock);
    this.cotizacionMock.setTimestamps(tsMock);
    assertEquals(this.cotizacionMock.toString(), modelTest.toString());
  }
}
