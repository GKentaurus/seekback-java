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
class BodegaTest {

  @InjectMocks
  private Bodega bodegaMock;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.bodegaMock.setId(id);
    assertNotNull(this.bodegaMock.getId());
    assertEquals(id, this.bodegaMock.getId());
  }

  @Test
  void attributeNombreBodegaTest() {
    String nombreBodega = "Bodega # 1";
    this.bodegaMock.setNombreBodega(nombreBodega);
    assertNotNull(this.bodegaMock.getNombreBodega());
    assertEquals(nombreBodega, this.bodegaMock.getNombreBodega());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.bodegaMock.setTimestamps(tsMock);
    assertNotNull(this.bodegaMock.getTimestamps());
    assertEquals(tsMock, this.bodegaMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Bodega modelTest = new Bodega();
    assertEquals(this.bodegaMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.bodegaMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Bodega modelTest = new Bodega();
    assertEquals(this.bodegaMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.bodegaMock.equals(this.bodegaMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Bodega modelTest = new Bodega();
    modelTest.setId(1);
    modelTest.setNombreBodega("Bodega # 1");
    assertNotEquals(this.bodegaMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.bodegaMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.bodegaMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Bodega modelTest = new Bodega();
    modelTest.setTimestamps(tsMock);
    this.bodegaMock.setTimestamps(tsMock);
    assertEquals(this.bodegaMock.toString(), modelTest.toString());
  }
}
