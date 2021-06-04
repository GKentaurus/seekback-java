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
class TelefonoTest {
  @InjectMocks
  private Telefono telefonoMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.telefonoMock.setId(id);
    assertNotNull(this.telefonoMock.getId());
    assertEquals(id, this.telefonoMock.getId());
  }

  @Test
  void attributeUsuarioTest() {
    Usuario usuario = Mockito.mock(Usuario.class);
    this.telefonoMock.setUsuario(usuario);
    assertNotNull(this.telefonoMock.getUsuario());
    assertEquals(usuario, this.telefonoMock.getUsuario());
  }

  @Test
  void attributeNumeroTelefonoTest() {
    String numero = "3004950049";
    this.telefonoMock.setNumeroTelefono(numero);
    assertNotNull(this.telefonoMock.getNumeroTelefono());
    assertEquals(numero, this.telefonoMock.getNumeroTelefono());
  }

  @Test
  void attributeEsPrincipalTrueTest() {
    this.telefonoMock.setEsPrincipal(true);
    assertTrue(this.telefonoMock.getEsPrincipal());
  }

  @Test
  void attributeEsPrincipalFalseTest() {
    this.telefonoMock.setEsPrincipal(false);
    assertFalse(this.telefonoMock.getEsPrincipal());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.telefonoMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.telefonoMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Telefono modelTest = new Telefono();
    assertEquals(this.telefonoMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.telefonoMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Telefono modelTest = new Telefono();
    assertEquals(this.telefonoMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.telefonoMock.equals(this.telefonoMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Telefono modelTest = new Telefono();
    modelTest.setId(1);
    modelTest.setEsPrincipal(true);
    assertNotEquals(this.telefonoMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.telefonoMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.telefonoMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Telefono modelTest = new Telefono();
    modelTest.setTimestamps(tsMock);
    this.telefonoMock.setTimestamps(tsMock);
    assertEquals(this.telefonoMock.toString(), modelTest.toString());
  }
}
