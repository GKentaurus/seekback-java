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
class ProveedorTest {
  @InjectMocks
  private Proveedor proveedorMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.proveedorMock.setId(id);
    assertNotNull(this.proveedorMock.getId());
    assertEquals(id, this.proveedorMock.getId());
  }

  @Test
  void attributeTipoDocTest() {
    TipoDoc tipoDoc = Mockito.mock(TipoDoc.class);
    this.proveedorMock.setTipoDoc(tipoDoc);
    assertNotNull(this.proveedorMock.getTipoDoc());
    assertEquals(tipoDoc, this.proveedorMock.getTipoDoc());
  }

  @Test
  void attributeNumeroDocTest() {
    String numero = "102931283098";
    this.proveedorMock.setNumeroDoc(numero);
    assertNotNull(this.proveedorMock.getNumeroDoc());
    assertEquals(numero, this.proveedorMock.getNumeroDoc());
  }

  @Test
  void attributeDigitoVerifTest() {
    String digito = "1";
    this.proveedorMock.setDigitoVerif(digito);
    assertNotNull(this.proveedorMock.getDigitoVerif());
    assertEquals(digito, this.proveedorMock.getDigitoVerif());
  }

  @Test
  void attributeRazonSocialTest() {
    String razonSocial = "Compumundo Hpermegaweb";
    this.proveedorMock.setRazonSocial(razonSocial);
    assertNotNull(this.proveedorMock.getRazonSocial());
    assertEquals(razonSocial, this.proveedorMock.getRazonSocial());
  }

  @Test
  void attributeTelefonoTest() {
    String telefono = "31099988877";
    this.proveedorMock.setTelefono(telefono);
    assertNotNull(this.proveedorMock.getTelefono());
    assertEquals(telefono, this.proveedorMock.getTelefono());
  }

  @Test
  void attributeEmailTest() {
    String email = "correo@correo.com";
    this.proveedorMock.setEmail(email);
    assertNotNull(this.proveedorMock.getEmail());
    assertEquals(email, this.proveedorMock.getEmail());
  }

  @Test
  void attributeClienteTest() {
    Usuario cliente = Mockito.mock(Usuario.class);
    this.proveedorMock.setCliente(cliente);
    assertNotNull(this.proveedorMock.getCliente());
    assertEquals(cliente, this.proveedorMock.getCliente());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.proveedorMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.proveedorMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Proveedor modelTest = new Proveedor();
    assertEquals(this.proveedorMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.proveedorMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Proveedor modelTest = new Proveedor();
    assertEquals(this.proveedorMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.proveedorMock.equals(this.proveedorMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Proveedor modelTest = new Proveedor();
    modelTest.setId(1);
    modelTest.setRazonSocial("Nombre empresa");
    assertNotEquals(this.proveedorMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.proveedorMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.proveedorMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Proveedor modelTest = new Proveedor();
    modelTest.setTimestamps(tsMock);
    this.proveedorMock.setTimestamps(tsMock);
    assertEquals(this.proveedorMock.toString(), modelTest.toString());
  }
}
