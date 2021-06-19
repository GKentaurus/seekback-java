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
class SlideTest {

  @InjectMocks
  private Slide slideMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.slideMock.setId(id);
    assertNotNull(this.slideMock.getId());
    assertEquals(id, this.slideMock.getId());
  }

  @Test
  void attributeTituloTest() {
    String titulo = "Titulo del Slider";
    this.slideMock.setTitulo(titulo);
    assertNotNull(this.slideMock.getTitulo());
    assertEquals(titulo, this.slideMock.getTitulo());
  }

  @Test
  void attributeDescripcionTest() {
    String descripcion = "Descripción del slider";
    this.slideMock.setDescripcion(descripcion);
    assertNotNull(this.slideMock.getDescripcion());
    assertEquals(descripcion, this.slideMock.getDescripcion());
  }

  @Test
  void attributeUrlImagenTest() {
    String url = "/img/img.jpg";
    this.slideMock.setUrlImagen(url);
    assertNotNull(this.slideMock.getUrlImagen());
    assertEquals(url, this.slideMock.getUrlImagen());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.slideMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.slideMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Slide modelTest = new Slide();
    assertEquals(this.slideMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.slideMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Slide modelTest = new Slide();
    assertEquals(this.slideMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.slideMock.equals(this.slideMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Slide modelTest = new Slide();
    modelTest.setId(1);
    modelTest.setTitulo("Titulo");
    assertNotEquals(this.slideMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.slideMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.slideMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Slide modelTest = new Slide();
    modelTest.setTimestamps(tsMock);
    this.slideMock.setTimestamps(tsMock);
    assertEquals(this.slideMock.toString(), modelTest.toString());
  }
}
