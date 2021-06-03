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
class DepartamentoTest {

  @InjectMocks
  private Departamento departamentoMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.departamentoMock.setId(id);
    assertNotNull(this.departamentoMock.getId());
    assertEquals(id, this.departamentoMock.getId());
  }

  @Test
  void attributePaisTest() {
    Pais pais = Mockito.mock(Pais.class);
    this.departamentoMock.setPais(pais);
    assertNotNull(this.departamentoMock.getPais());
    assertEquals(pais, this.departamentoMock.getPais());
  }

  @Test
  void attributeNombreDepartamentoTest() {
    String nombreDepartamento = "Nombre del Departamento";
    this.departamentoMock.setNombreDepartamento(nombreDepartamento);
    assertNotNull(this.departamentoMock.getNombreDepartamento());
    assertEquals(nombreDepartamento, this.departamentoMock.getNombreDepartamento());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.departamentoMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.departamentoMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Departamento modelTest = new Departamento();
    assertEquals(this.departamentoMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.departamentoMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Departamento modelTest = new Departamento();
    assertEquals(this.departamentoMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.departamentoMock.equals(this.departamentoMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Departamento modelTest = new Departamento();
    modelTest.setId(1);
    modelTest.setNombreDepartamento("Nombre del departamento # 1");
    assertNotEquals(this.departamentoMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.departamentoMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.departamentoMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Departamento modelTest = new Departamento();
    modelTest.setTimestamps(tsMock);
    this.departamentoMock.setTimestamps(tsMock);
    assertEquals(this.departamentoMock.toString(), modelTest.toString());
  }
}
