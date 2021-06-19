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
class PaisTest {

  @InjectMocks
  private Pais paisMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 12;
    this.paisMock.setId(id);
    assertNotNull(this.paisMock.getId());
    assertEquals(id, this.paisMock.getId());
  }

  @Test
  void attributeNombrePaisTest() {
    String nombre = "Colombia";
    this.paisMock.setNombrePais(nombre);
    assertNotNull(this.paisMock.getNombrePais());
    assertEquals(nombre, this.paisMock.getNombrePais());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.paisMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.paisMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Pais modelTest = new Pais();
    assertEquals(this.paisMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.paisMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Pais modelTest = new Pais();
    assertEquals(this.paisMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.paisMock.equals(this.paisMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Pais modelTest = new Pais();
    modelTest.setId(1);
    modelTest.setNombrePais("Pais # 1");
    assertNotEquals(this.paisMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.paisMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.paisMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Pais modelTest = new Pais();
    modelTest.setTimestamps(tsMock);
    this.paisMock.setTimestamps(tsMock);
    assertEquals(this.paisMock.toString(), modelTest.toString());
  }
}
