package tech.seekback.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tech.seekback.models.templates.Timestamps;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

  @InjectMocks
  private Usuario usuarioMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.usuarioMock.setId(id);
    assertNotNull(this.usuarioMock.getId());
    assertEquals(id, this.usuarioMock.getId());
  }

  @Test
  void attributePrimerNombreTest() {
    String primerNombre = "Carlos";
    this.usuarioMock.setPrimerNombre(primerNombre);
    assertNotNull(this.usuarioMock.getPrimerNombre());
    assertEquals(primerNombre, this.usuarioMock.getPrimerNombre());
  }

  @Test
  void attributeOtrosNombresTest() {
    String otroNombre = "Alberto";
    this.usuarioMock.setOtrosNombres(otroNombre);
    assertNotNull(this.usuarioMock.getOtrosNombres());
    assertEquals(otroNombre, this.usuarioMock.getOtrosNombres());
  }

  @Test
  void attributePrimerApellidoTest() {
    String primerApellido = "Carlos";
    this.usuarioMock.setPrimerApellido(primerApellido);
    assertNotNull(this.usuarioMock.getPrimerApellido());
    assertEquals(primerApellido, this.usuarioMock.getPrimerApellido());
  }

  @Test
  void attributeOtrosApellidosTest() {
    String otrosApellidos = "Carlos";
    this.usuarioMock.setOtrosApellidos(otrosApellidos);
    assertNotNull(this.usuarioMock.getOtrosApellidos());
    assertEquals(otrosApellidos, this.usuarioMock.getOtrosApellidos());
  }

  @Test
  void attributeTipoDocTest() {
    TipoDoc docMock = Mockito.mock(TipoDoc.class);
    this.usuarioMock.setTipoDoc(docMock);
    assertNotNull(this.usuarioMock.getTipoDoc());
    assertEquals(docMock, this.usuarioMock.getTipoDoc());
  }

  @Test
  void attributeNumeroDocTest() {
    String numeroDoc = "1010100001";
    this.usuarioMock.setNumeroDoc(numeroDoc);
    assertNotNull(this.usuarioMock.getNumeroDoc());
    assertEquals(numeroDoc, this.usuarioMock.getNumeroDoc());
  }

  @Test
  void attributeContrasenaTest() {
    this.usuarioMock.setContrasena("123PorMi");
    assertNotNull(this.usuarioMock.getContrasena());
  }

  @Test
  void verificarContrasenaTest() {
    String contrasena = "123PorMi";
    this.usuarioMock.setContrasena(contrasena);
    boolean response = this.usuarioMock.verificarContrasena(contrasena);
    assertTrue(response);
  }

  @Test
  void attributeRolTest() {
    Rol rol = Mockito.mock(Rol.class);
    this.usuarioMock.setRol(rol);
    assertNotNull(this.usuarioMock.getRol());
    assertEquals(rol, this.usuarioMock.getRol());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.usuarioMock.setTimestamps(tsMock);
    assertNotNull(this.usuarioMock.getTimestamps());
    assertEquals(tsMock, this.usuarioMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Usuario modelTest = new Usuario();
    assertEquals(this.usuarioMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.usuarioMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Usuario modelTest = new Usuario();
    assertEquals(this.usuarioMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.usuarioMock.equals(this.usuarioMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Usuario modelTest = new Usuario();
    modelTest.setId(1);
    modelTest.setPrimerNombre("Camilo");
    assertNotEquals(this.usuarioMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.usuarioMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.usuarioMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Usuario modelTest = new Usuario();
    modelTest.setTimestamps(tsMock);
    this.usuarioMock.setTimestamps(tsMock);
    assertEquals(this.usuarioMock.toString(), modelTest.toString());
  }
}

