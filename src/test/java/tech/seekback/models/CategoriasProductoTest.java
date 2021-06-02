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
class CategoriasProductoTest {

  @InjectMocks
  private CategoriasProducto cpMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.cpMock.setId(id);
    assertNotNull(this.cpMock.getId());
    assertEquals(id, this.cpMock.getId());
  }

  @Test
  void attributeNombreCategoriaTest() {
    String nombreCategoria = "Nombre categoría";
    this.cpMock.setNombreCategoria(nombreCategoria);
    assertNotNull(this.cpMock.getNombreCategoria());
    assertEquals(nombreCategoria, this.cpMock.getNombreCategoria());
  }

  @Test
  void attributeFaIconTest() {
    String faIcon = "fab computer-icon";
    this.cpMock.setFaIcon(faIcon);
    assertNotNull(this.cpMock.getFaIcon());
    assertEquals(faIcon, this.cpMock.getFaIcon());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.cpMock.setTimestamps(tsMock);
    assertNotNull(this.cpMock.getTimestamps());
    assertEquals(tsMock, this.cpMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    CategoriasProducto modelTest = new CategoriasProducto();
    assertEquals(this.cpMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.cpMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    CategoriasProducto modelTest = new CategoriasProducto();
    assertEquals(this.cpMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.cpMock.equals(this.cpMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    CategoriasProducto modelTest = new CategoriasProducto();
    modelTest.setId(1);
    modelTest.setNombreCategoria("Nombre de la categoría");
    assertNotEquals(this.cpMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.cpMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.cpMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    CategoriasProducto modelTest = new CategoriasProducto();
    modelTest.setTimestamps(tsMock);
    this.cpMock.setTimestamps(tsMock);
    assertEquals(this.cpMock.toString(), modelTest.toString());
  }
}

