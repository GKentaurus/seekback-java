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
class ProformaVentaTest {

  @InjectMocks
  private ProformaVenta proformaMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.proformaMock.setId(id);
    assertNotNull(this.proformaMock.getId());
    assertEquals(id, this.proformaMock.getId());
  }

  @Test
  void attributeCotizacionTest() {
    Cotizacion cotizacion = Mockito.mock(Cotizacion.class);
    this.proformaMock.setCotizacion(cotizacion);
    assertNotNull(this.proformaMock.getCotizacion());
    assertEquals(cotizacion, this.proformaMock.getCotizacion());
  }

  @Test
  void attributeFechaTest() {
    Date fecha = new Date();
    this.proformaMock.setFecha(fecha);
    assertNotNull(this.proformaMock.getFecha());
    assertEquals(fecha, this.proformaMock.getFecha());
  }

  @Test
  void attributeVencimientoTest() {
    Date vencimiento = new Date();
    this.proformaMock.setVencimiento(vencimiento);
    assertNotNull(this.proformaMock.getVencimiento());
    assertEquals(vencimiento, this.proformaMock.getVencimiento());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.proformaMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.proformaMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    ProformaVenta modelTest = new ProformaVenta();
    assertEquals(this.proformaMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.proformaMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    ProformaVenta modelTest = new ProformaVenta();
    assertEquals(this.proformaMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.proformaMock.equals(this.proformaMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    ProformaVenta modelTest = new ProformaVenta();
    modelTest.setId(1);
    modelTest.setFecha(new Date());
    assertNotEquals(this.proformaMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.proformaMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.proformaMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    ProformaVenta modelTest = new ProformaVenta();
    modelTest.setTimestamps(tsMock);
    this.proformaMock.setTimestamps(tsMock);
    assertEquals(this.proformaMock.toString(), modelTest.toString());
  }
}
