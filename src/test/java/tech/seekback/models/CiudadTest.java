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
class CiudadTest {

  @InjectMocks
  private Ciudad ciudadMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.ciudadMock.setId(id);
    assertNotNull(this.ciudadMock.getId());
    assertEquals(id, this.ciudadMock.getId());
  }

  @Test
  void attributeDepartamentoTest() {
    Departamento departamento = Mockito.mock(Departamento.class);
    this.ciudadMock.setDepartamento(departamento);
    assertNotNull(this.ciudadMock.getDepartamento());
    assertEquals(departamento, this.ciudadMock.getDepartamento());
  }

  @Test
  void attributeNombreCiudadTest() {
    String nombreCiudad = "Nombre ciudad";
    this.ciudadMock.setNombreCiudad(nombreCiudad);
    assertNotNull(this.ciudadMock.getNombreCiudad());
    assertEquals(nombreCiudad, this.ciudadMock.getNombreCiudad());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.ciudadMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.ciudadMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Ciudad modelTest = new Ciudad();
    assertEquals(this.ciudadMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.ciudadMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Ciudad modelTest = new Ciudad();
    assertEquals(this.ciudadMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.ciudadMock.equals(this.ciudadMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Ciudad modelTest = new Ciudad();
    modelTest.setId(1);
    modelTest.setNombreCiudad("Ciudad # 1");
    assertNotEquals(this.ciudadMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.ciudadMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.ciudadMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Ciudad modelTest = new Ciudad();
    modelTest.setTimestamps(tsMock);
    this.ciudadMock.setTimestamps(tsMock);
    assertEquals(this.ciudadMock.toString(), modelTest.toString());
  }
}
