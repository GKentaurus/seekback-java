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
class CorreoTest {

  @InjectMocks
  private Correo correoMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.correoMock.setId(id);
    assertNotNull(this.correoMock.getId());
    assertEquals(id, this.correoMock.getId());
  }

  @Test
  void attributeUsuarioTest() {
    Usuario usuario = Mockito.mock(Usuario.class);
    this.correoMock.setUsuario(usuario);
    assertNotNull(this.correoMock.getUsuario());
    assertEquals(usuario, this.correoMock.getUsuario());
  }

  @Test
  void attributeCorreoElectronicoTest() {
    String correoElectronico = "correo@correo.com";
    this.correoMock.setCorreoElectronico(correoElectronico);
    assertNotNull(this.correoMock.getCorreoElectronico());
    assertEquals(correoElectronico, this.correoMock.getCorreoElectronico());
  }

  @Test
  void attributeEsPrincipalTrueTest() {
    this.correoMock.setEsPrincipal(true);
    assertTrue(this.correoMock.getEsPrincipal());
  }

  @Test
  void attributeEsPrincipalFalseTest() {
    this.correoMock.setEsPrincipal(false);
    assertFalse(this.correoMock.getEsPrincipal());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.correoMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.correoMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Correo modelTest = new Correo();
    assertEquals(this.correoMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.correoMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Correo modelTest = new Correo();
    assertEquals(this.correoMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.correoMock.equals(this.correoMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Correo modelTest = new Correo();
    modelTest.setId(1);
    modelTest.setCorreoElectronico("correo2@correo.com");
    assertNotEquals(this.correoMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.correoMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.correoMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Correo modelTest = new Correo();
    modelTest.setTimestamps(tsMock);
    this.correoMock.setTimestamps(tsMock);
    assertEquals(this.correoMock.toString(), modelTest.toString());
  }
}
