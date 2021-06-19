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
class EstadosCotizacionTest {

  @InjectMocks
  private EstadosCotizacion estadoMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attribteIdTest() {
    Integer id = 1;
    this.estadoMock.setId(id);
    assertNotNull(this.estadoMock.getId());
    assertEquals(id, this.estadoMock.getId());
  }

  @Test
  void attribteNombreEstadoTest() {
    String nombre = "Nombre del Estado";
    this.estadoMock.setNombreEstado(nombre);
    assertNotNull(this.estadoMock.getNombreEstado());
    assertEquals(nombre, this.estadoMock.getNombreEstado());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.estadoMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.estadoMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    EstadosCotizacion modelTest = new EstadosCotizacion();
    assertEquals(this.estadoMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.estadoMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    EstadosCotizacion modelTest = new EstadosCotizacion();
    assertEquals(this.estadoMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.estadoMock.equals(this.estadoMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    EstadosCotizacion modelTest = new EstadosCotizacion();
    modelTest.setId(1);
    modelTest.setNombreEstado("Estado # 1");
    assertNotEquals(this.estadoMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.estadoMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.estadoMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    EstadosCotizacion modelTest = new EstadosCotizacion();
    modelTest.setTimestamps(tsMock);
    this.estadoMock.setTimestamps(tsMock);
    assertEquals(this.estadoMock.toString(), modelTest.toString());
  }
}

