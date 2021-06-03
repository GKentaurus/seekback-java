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
class DivisaTest {

  @InjectMocks
  private Divisa divisaMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.divisaMock.setId(id);
    assertNotNull(this.divisaMock.getId());
    assertEquals(id, this.divisaMock.getId());
  }

  @Test
  void attributeNombreTest() {
    String nombre = "EURO";
    this.divisaMock.setNombre(nombre);
    assertNotNull(this.divisaMock.getNombre());
    assertEquals(nombre, this.divisaMock.getNombre());
  }

  @Test
  void attributeSiglaTest() {
    String sigla = "EUR";
    this.divisaMock.setSigla(sigla);
    assertNotNull(this.divisaMock.getSigla());
    assertEquals(sigla, this.divisaMock.getSigla());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.divisaMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.divisaMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Divisa modelTest = new Divisa();
    assertEquals(this.divisaMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.divisaMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Divisa modelTest = new Divisa();
    assertEquals(this.divisaMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.divisaMock.equals(this.divisaMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Divisa modelTest = new Divisa();
    modelTest.setId(1);
    modelTest.setNombre("Divisa # 1");
    assertNotEquals(this.divisaMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.divisaMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.divisaMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Divisa modelTest = new Divisa();
    modelTest.setTimestamps(tsMock);
    this.divisaMock.setTimestamps(tsMock);
    assertEquals(this.divisaMock.toString(), modelTest.toString());
  }
}

