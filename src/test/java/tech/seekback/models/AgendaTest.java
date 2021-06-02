package tech.seekback.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.seekback.models.templates.Timestamps;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class AgendaTest {

  @InjectMocks
  private Agenda agendaMock;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void attributeIdTes() {
    Integer id = 1;
    this.agendaMock.setId(id);
    assertNotNull(this.agendaMock.getId());
    assertEquals(id, this.agendaMock.getId());
  }

  @Test
  void attributeFechaTest() {
    Date date = new Date();
    this.agendaMock.setFecha(date);
    assertNotNull(this.agendaMock.getFecha());
    assertEquals(date, this.agendaMock.getFecha());
  }

  @Test
  void attributeObservacionesTest() {
    String observaciones = "Observaciones";
    this.agendaMock.setObservaciones(observaciones);
    assertNotNull(this.agendaMock.getObservaciones());
    assertEquals(observaciones, this.agendaMock.getObservaciones());
  }

  @Test
  void attributeEstadoTest() {
    EstadosAgenda eaMock = mock(EstadosAgenda.class);
    this.agendaMock.setEstado(eaMock);
    assertNotNull(this.agendaMock.getEstado());
    assertEquals(eaMock, this.agendaMock.getEstado());
  }

  @Test
  void attributeTipoServicioTest() {
    TipoServicio tsMock = mock(TipoServicio.class);
    this.agendaMock.setTipoServicio(tsMock);
    assertNotNull(this.agendaMock.getTipoServicio());
    assertEquals(tsMock, this.agendaMock.getTipoServicio());
  }

  @Test
  void attributeClienteTest() {
    Usuario cMock = mock(Usuario.class);
    this.agendaMock.setCliente(cMock);
    assertNotNull(this.agendaMock.getCliente());
    assertEquals(cMock, this.agendaMock.getCliente());
  }

  @Test
  void attributeEmpleadoTest() {
    Usuario eMock = mock(Usuario.class);
    this.agendaMock.setEmpleado(eMock);
    assertNotNull(this.agendaMock.getEmpleado());
    assertEquals(eMock, this.agendaMock.getEmpleado());
  }

  @Test
  void attributeAdministradorTest() {
    Usuario aMock = mock(Usuario.class);
    this.agendaMock.setAdministrador(aMock);
    assertNotNull(this.agendaMock.getAdministrador());
    assertEquals(aMock, this.agendaMock.getAdministrador());
  }

  @Test
  void attributeTimestampsTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    this.agendaMock.setTimestamps(tsMock);
    assertNotNull(this.agendaMock.getTimestamps());
    assertEquals(tsMock, this.agendaMock.getTimestamps());
  }

  @Test
  void hashCodeEqualsTest() {
    Agenda modelTest = new Agenda();
    assertEquals(this.agendaMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void hashCodeNotEqualsTest() {
    Object modelTest = new Object();
    assertNotEquals(this.agendaMock.hashCode(), modelTest.hashCode());
  }

  @Test
  void equalsWithSameObjectClassReturnsTrueTest() {
    Agenda modelTest = new Agenda();
    assertEquals(this.agendaMock, modelTest);
  }

  @Test
  void equalsWithSameObjectReturnsTrueTest() {
    assertTrue(this.agendaMock.equals(this.agendaMock));
  }

  @Test
  void equalsWithDifferentObjectsReturnsFalseTest() {
    Agenda modelTest = new Agenda();
    modelTest.setId(1);
    modelTest.setObservaciones("Agenda # 1");
    assertNotEquals(this.agendaMock, modelTest);
  }

  @Test
  void equalsWithNullObjectReturnsFalseTest() {
    assertFalse(this.agendaMock.equals(null));
  }

  @Test
  void equalsWithDifferentClassObjectReturnsFalseTest() {
    assertFalse(this.agendaMock.equals(""));
  }

  @Test
  void toStringTest() {
    Timestamps tsMock = Mockito.mock(Timestamps.class);
    Agenda modelTest = new Agenda();
    modelTest.setTimestamps(tsMock);
    this.agendaMock.setTimestamps(tsMock);
    assertEquals(this.agendaMock.toString(), modelTest.toString());
  }
}
