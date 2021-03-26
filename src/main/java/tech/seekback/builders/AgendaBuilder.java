
package tech.seekback.builders;

import tech.seekback.models.*;
import tech.seekback.models.templates.Timestamps;

import java.util.Date;

/**
 * @author gkentaurus
 */
public class AgendaBuilder {

  private final Agenda agenda;

  private AgendaBuilder() {
    this.agenda = new Agenda();
  }

  public static AgendaBuilder builder() {
    return new AgendaBuilder();
  }

  public AgendaBuilder id(Integer id) {
    this.agenda.setId(id);
    return this;
  }

  public AgendaBuilder fecha(Date fecha) {
    this.agenda.setFecha(fecha);
    return this;
  }

  public AgendaBuilder observaciones(String observaciones) {
    this.agenda.setObservaciones(observaciones);
    return this;
  }

  public AgendaBuilder estado(EstadosAgenda idEstado) {
    this.agenda.setEstado(idEstado);
    return this;
  }

  public AgendaBuilder tipoServicio(TipoServicio tipoServicio) {
    this.agenda.setTipoServicio(tipoServicio);
    return this;
  }

  public AgendaBuilder cliente(Cliente cliente) {
    this.agenda.setCliente(cliente);
    return this;
  }

  public AgendaBuilder empleado(Empleado empleado) {
    this.agenda.setEmpleado(empleado);
    return this;
  }

  public AgendaBuilder administrador(Administrador administrador) {
    this.agenda.setAdministrador(administrador);
    return this;
  }

  public AgendaBuilder timestamps(Timestamps timestamps) {
    this.agenda.setTimestamps(timestamps);
    return this;
  }

  public Agenda build() {
    return this.agenda;
  }
}
