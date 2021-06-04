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
class RolTest {
  @InjectMocks
  private Rol rolMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.rolMock.setId(id);
    assertNotNull(this.rolMock.getId());
    assertEquals(id, this.rolMock.getId());
  }

  @Test
  void attributeNombreRolTest() {
    String nombre = "Asesor";
    this.rolMock.setNombreRol(nombre);
    assertNotNull(this.rolMock.getNombreRol());
    assertNotNull(nombre, this.rolMock.getNombreRol());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.rolMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.rolMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Rol modelTest = new Rol();
    assertEquals(this.rolMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.rolMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Rol modelTest = new Rol();
    assertEquals(this.rolMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.rolMock.equals(this.rolMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Rol modelTest = new Rol();
    modelTest.setId(1);
    modelTest.setNombreRol("Asesor");
    assertNotEquals(this.rolMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.rolMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.rolMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Rol modelTest = new Rol();
    modelTest.setTimestamps(tsMock);
    this.rolMock.setTimestamps(tsMock);
    assertEquals(this.rolMock.toString(), modelTest.toString());
  }
}
