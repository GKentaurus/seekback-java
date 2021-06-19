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
class TipoServicioTest {

  @InjectMocks
  private TipoServicio tsMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.tsMock.setId(id);
    assertNotNull(this.tsMock.getId());
    assertEquals(id, this.tsMock.getId());
  }

  @Test
  void attributeNombreServicioTest() {
    String nombre = "Nombre Servicio";
    this.tsMock.setNombreServicio(nombre);
    assertNotNull(this.tsMock.getNombreServicio());
    assertEquals(nombre, this.tsMock.getNombreServicio());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.tsMock.setTimestamps(tsMock);
    assertNotNull(this.tsMock.getTimestamps());
    assertEquals(tsMock, this.tsMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    TipoServicio modelTest = new TipoServicio();
    assertEquals(this.tsMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.tsMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    TipoServicio modelTest = new TipoServicio();
    assertEquals(this.tsMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.tsMock.equals(this.tsMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    TipoServicio modelTest = new TipoServicio();
    modelTest.setId(1);
    modelTest.setNombreServicio("TipoServicio # 1");
    assertNotEquals(this.tsMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.tsMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.tsMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    TipoServicio modelTest = new TipoServicio();
    modelTest.setTimestamps(tsMock);
    this.tsMock.setTimestamps(tsMock);
    assertEquals(this.tsMock.toString(), modelTest.toString());
  }
}
