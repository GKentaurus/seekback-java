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
class TipoDocTest {

  @InjectMocks
  private TipoDoc tdMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }
  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.tdMock.setId(id);
    assertNotNull(this.tdMock.getId());
    assertEquals(id, this.tdMock.getId());
  }

  @Test
  void attributeSiglaTest() {
    String sigla = "C.C.";
    this.tdMock.setSigla(sigla);
    assertNotNull(this.tdMock.getSigla());
    assertEquals(sigla, this.tdMock.getSigla());
  }

  @Test
  void attributeNombreDocumentoTest() {
    String nombre = "Cédula de Ciudadanía";
    this.tdMock.setNombreDocumento(nombre);
    assertNotNull(this.tdMock.getNombreDocumento());
    assertEquals(nombre, this.tdMock.getNombreDocumento());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.tdMock.setTimestamps(tsMock);
    assertNotNull(this.tdMock.getTimestamps());
    assertEquals(tsMock, this.tdMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    TipoDoc modelTest = new TipoDoc();
    assertEquals(this.tdMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.tdMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    TipoDoc modelTest = new TipoDoc();
    assertEquals(this.tdMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertEquals(this.tdMock, this.tdMock);
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    TipoDoc modelTest = new TipoDoc();
    modelTest.setId(1);
    modelTest.setNombreDocumento("TipoDoc # 1");
    assertNotEquals(this.tdMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertNotEquals(null, this.tdMock);
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.tdMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    TipoDoc modelTest = new TipoDoc();
    modelTest.setTimestamps(tsMock);
    this.tdMock.setTimestamps(tsMock);
    assertEquals(this.tdMock.toString(), modelTest.toString());
  }
}

