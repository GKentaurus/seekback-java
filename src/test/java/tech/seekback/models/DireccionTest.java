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
class DireccionTest {

  @InjectMocks
  private Direccion direccionMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.direccionMock.setId(id);
    assertNotNull(this.direccionMock.getId());
    assertEquals(id, this.direccionMock.getId());
  }

  @Test
  void attributeUsuarioTest() {
    Usuario usuario = Mockito.mock(Usuario.class);
    this.direccionMock.setUsuario(usuario);
    assertNotNull(this.direccionMock.getUsuario());
    assertEquals(usuario, this.direccionMock.getUsuario());
  }

  @Test
  void attributePseudonimoTest() {
    String pseudonimo = "Pseudonimo de  dirección";
    this.direccionMock.setPseudonimo(pseudonimo);
    assertNotNull(this.direccionMock.getPseudonimo());
    assertEquals(pseudonimo, this.direccionMock.getPseudonimo());
  }

  @Test
  void attributeDireccionTest() {
    String direccion = "Av Falsa 123, Bogotá";
    this.direccionMock.setDireccion(direccion);
    assertNotNull(this.direccionMock.getDireccion());
    assertEquals(direccion, this.direccionMock.getDireccion());
  }

  @Test
  void attributeTelefonoTest() {
    String telefono = " 300 5555555";
    this.direccionMock.setTelefono(telefono);
    assertNotNull(this.direccionMock.getTelefono());
    assertEquals(telefono, this.direccionMock.getTelefono());
  }

  @Test
  void attributeEsPrincipalWhenTrueTest() {
    this.direccionMock.setEsPrincipal(true);
    assertTrue(this.direccionMock.isEsPrincipal());
  }

  @Test
  void attributeEsPrincipalWhenFalseTest() {
    this.direccionMock.setEsPrincipal(false);
    assertFalse(this.direccionMock.isEsPrincipal());
  }


  @Test
  void attributeCiudadTest() {
    Ciudad ciudad = Mockito.mock(Ciudad.class);
    this.direccionMock.setCiudad(ciudad);
    assertNotNull(this.direccionMock.getCiudad());
    assertEquals(ciudad, this.direccionMock.getCiudad());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.direccionMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.direccionMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Direccion modelTest = new Direccion();
    assertEquals(this.direccionMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.direccionMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Direccion modelTest = new Direccion();
    assertEquals(this.direccionMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.direccionMock.equals(this.direccionMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Direccion modelTest = new Direccion();
    modelTest.setId(1);
    modelTest.setPseudonimo("Pseudónimo # 1");
    assertNotEquals(this.direccionMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.direccionMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.direccionMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Direccion modelTest = new Direccion();
    modelTest.setTimestamps(tsMock);
    this.direccionMock.setTimestamps(tsMock);
    assertEquals(this.direccionMock.toString(), modelTest.toString());
  }
}

