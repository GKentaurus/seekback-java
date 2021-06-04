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

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class PQRSTest {

  @InjectMocks
  private PQRS pqrsMock;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }
  @Test
  void attributeIdTest() {
    Integer id = 1;
    this.pqrsMock.setId(id);
    assertNotNull(this.pqrsMock.getId());
    assertEquals(id, this.pqrsMock.getId());
  }

  @Test
  void attributeTipoSolicitudTest() {
    TipoSolicitud solicitud = Mockito.mock(TipoSolicitud.class);
    this.pqrsMock.setTipoSolicitud(solicitud);
    assertNotNull(this.pqrsMock.getTipoSolicitud());
    assertEquals(solicitud, this.pqrsMock.getTipoSolicitud());
  }

  @Test
  void attributeAreaTest() {
    String area = "Administración";
    this.pqrsMock.setArea(area);
    assertNotNull(this.pqrsMock.getArea());
    assertEquals(area, this.pqrsMock.getArea());
  }

  @Test
  void attributeEstadoTest() {
    EstadosFidelizacion estado = Mockito.mock(EstadosFidelizacion.class);
    this.pqrsMock.setEstado(estado);
    assertNotNull(this.pqrsMock.getEstado());
    assertEquals(estado, this.pqrsMock.getEstado());
  }

  @Test
  void attributeClienteTest() {
    Usuario cliente = Mockito.mock(Usuario.class);
    this.pqrsMock.setCliente(cliente);
    assertNotNull(this.pqrsMock.getCliente());
    assertEquals(cliente, this.pqrsMock.getCliente());
  }

  @Test
  void attributeAdministradorTest() {
    Usuario administrador = Mockito.mock(Usuario.class);
    this.pqrsMock.setAdministrador(administrador);
    assertNotNull(this.pqrsMock.getAdministrador());
    assertEquals(administrador, this.pqrsMock.getAdministrador());
  }

  @Test
  void attributeComentarioTest() {
    String comentario = "Comentario del PQRS";
    this.pqrsMock.setComentario(comentario);
    assertNotNull(this.pqrsMock.getComentario());
    assertEquals(comentario, this.pqrsMock.getComentario());
  }

  @Test
  void attributeRespuestaTest() {
    String respuesta = "Respuesta del PQRS";
    this.pqrsMock.setRespuesta(respuesta);
    assertNotNull(this.pqrsMock.getRespuesta());
    assertEquals(respuesta, this.pqrsMock.getRespuesta());
  }

  @Test
  void attributeFechaRespuestaTest() {
    Date fechaRespuesta = new Date();
    this.pqrsMock.setFechaRespuesta(fechaRespuesta);
    assertNotNull(this.pqrsMock.getFechaRespuesta());
    assertEquals(fechaRespuesta, this.pqrsMock.getFechaRespuesta());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.pqrsMock.setTimestamps(tsMock);
    assertEquals(tsMock, this.pqrsMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    PQRS modelTest = new PQRS();
    assertEquals(this.pqrsMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.pqrsMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    PQRS modelTest = new PQRS();
    assertEquals(this.pqrsMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.pqrsMock.equals(this.pqrsMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    PQRS modelTest = new PQRS();
    modelTest.setId(1);
    modelTest.setComentario("Comentario # 1");
    assertNotEquals(this.pqrsMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.pqrsMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.pqrsMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    PQRS modelTest = new PQRS();
    modelTest.setTimestamps(tsMock);
    this.pqrsMock.setTimestamps(tsMock);
    assertEquals(this.pqrsMock.toString(), modelTest.toString());
  }
}

