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
class FelicitacionTest {

  @InjectMocks
  private Felicitacion felicitacionMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.felicitacionMock.setId(id);
    assertNotNull(this.felicitacionMock.getId());
    assertEquals(id, this.felicitacionMock.getId());
  }

  @Test
  void attributeDirigidoATest() {
    String dirigidoA = "Administración";
    this.felicitacionMock.setDirigidoA(dirigidoA);
    assertNotNull(this.felicitacionMock.getDirigidoA());
    assertEquals(dirigidoA, this.felicitacionMock.getDirigidoA());
  }

  @Test
  void attributeClienteTest() {
    Usuario cliente = Mockito.mock(Usuario.class);
    this.felicitacionMock.setCliente(cliente);
    assertNotNull(this.felicitacionMock.getCliente());
    assertEquals(cliente, this.felicitacionMock.getCliente());
  }

  @Test
  void attributeComentarioTest() {
    String comentario = "Comentario de la felicitación";
    this.felicitacionMock.setComentario(comentario);
    assertNotNull(this.felicitacionMock.getComentario());
    assertEquals(comentario, this.felicitacionMock.getComentario());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.felicitacionMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.felicitacionMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Felicitacion modelTest = new Felicitacion();
    assertEquals(this.felicitacionMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.felicitacionMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Felicitacion modelTest = new Felicitacion();
    assertEquals(this.felicitacionMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.felicitacionMock.equals(this.felicitacionMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Felicitacion modelTest = new Felicitacion();
    modelTest.setId(1);
    modelTest.setComentario("Comentario # 1");
    assertNotEquals(this.felicitacionMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.felicitacionMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.felicitacionMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Felicitacion modelTest = new Felicitacion();
    modelTest.setTimestamps(tsMock);
    this.felicitacionMock.setTimestamps(tsMock);
    assertEquals(this.felicitacionMock.toString(), modelTest.toString());
  }
}

