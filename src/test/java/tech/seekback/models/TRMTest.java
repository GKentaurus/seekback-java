package tech.seekback.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tech.seekback.models.templates.Timestamps;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TRMTest {

  @InjectMocks
  private TRM trmMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.trmMock.setId(id);
    assertNotNull(this.trmMock.getId());
    assertEquals(id, this.trmMock.getId());
  }

  @Test
  void attributeDivisaTest() {
    Divisa divisa = Mockito.mock(Divisa.class);
    this.trmMock.setDivisa(divisa);
    assertNotNull(this.trmMock.getDivisa());
    assertEquals(divisa, this.trmMock.getDivisa());
  }

  @Test
  void attributeFechaTest() {
    Date date = new Date();
    this.trmMock.setFecha(date);
    assertNotNull(this.trmMock.getFecha());
    assertEquals(date, this.trmMock.getFecha());
  }

  @Test
  void attributeTasaCambioTest() {
    Double tasa = 3000D;
    this.trmMock.setTasaCambio(tasa);
    assertNotNull(this.trmMock.getTasaCambio());
    assertEquals(tasa, this.trmMock.getTasaCambio());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.trmMock.setTimestamps(tsMock);
    assertNotNull(this.trmMock.getTimestamps());
    assertEquals(tsMock, this.trmMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    TRM modelTest = new TRM();
    assertEquals(this.trmMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.trmMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    TRM modelTest = new TRM();
    assertEquals(this.trmMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.trmMock.equals(this.trmMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    TRM modelTest = new TRM();
    modelTest.setId(1);
    modelTest.setTasaCambio(3000D);
    assertNotEquals(this.trmMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.trmMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.trmMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    TRM modelTest = new TRM();
    modelTest.setTimestamps(tsMock);
    this.trmMock.setTimestamps(tsMock);
    assertEquals(this.trmMock.toString(), modelTest.toString());
  }
}
