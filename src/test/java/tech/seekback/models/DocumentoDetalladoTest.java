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
class DocumentoDetalladoTest {

  @InjectMocks
  private DocumentoDetallado ddMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.ddMock.setId(id);
    assertNotNull(this.ddMock.getId());
    assertEquals(id, this.ddMock.getId());
  }

  @Test
  void attributePrefijoDocumentoTest() {
    String prefix = "FVSB";
    this.ddMock.setPrefijoDocumento(prefix);
    assertNotNull(this.ddMock.getPrefijoDocumento());
    assertEquals(prefix, this.ddMock.getPrefijoDocumento());
  }

  @Test
  void attributeConsecutivoTest() {
    Integer consecutivo = 199213;
    this.ddMock.setConsecutivo(consecutivo);
    assertNotNull(this.ddMock.getConsecutivo());
    assertEquals(consecutivo, this.ddMock.getConsecutivo());
  }

  @Test
  void attributeProductoTest() {
    Producto producto = Mockito.mock(Producto.class);
    this.ddMock.setProducto(producto);
    assertNotNull(this.ddMock.getProducto());
    assertEquals(producto, this.ddMock.getProducto());
  }

  @Test
  void attributeCantidadTest() {
    Integer cantidad = 10;
    this.ddMock.setCantidad(cantidad);
    assertNotNull(this.ddMock.getCantidad());
    assertEquals(cantidad, this.ddMock.getCantidad());
  }

  @Test
  void attributeValorUnitarioTest() {
    Double valor = 100000D;
    this.ddMock.setValorUnitario(valor);
    assertNotNull(this.ddMock.getValorUnitario());
    assertEquals(valor, this.ddMock.getValorUnitario());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.ddMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.ddMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    DocumentoDetallado modelTest = new DocumentoDetallado();
    assertEquals(this.ddMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.ddMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    DocumentoDetallado modelTest = new DocumentoDetallado();
    assertEquals(this.ddMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.ddMock.equals(this.ddMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    DocumentoDetallado modelTest = new DocumentoDetallado();
    modelTest.setId(1);
    modelTest.setValorUnitario(250000D);
    assertNotEquals(this.ddMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.ddMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.ddMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    DocumentoDetallado modelTest = new DocumentoDetallado();
    modelTest.setTimestamps(tsMock);
    this.ddMock.setTimestamps(tsMock);
    assertEquals(this.ddMock.toString(), modelTest.toString());
  }
}
