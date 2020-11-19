/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import java.util.Date;
import tech.seekback.models.Administrador;
import tech.seekback.models.Agenda;
import tech.seekback.models.Cliente;
import tech.seekback.models.Empleado;
import tech.seekback.models.EstadosAgenda;
import tech.seekback.models.TipoServicio;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class AgendaBuilder {

  private Agenda agenda;

  private AgendaBuilder() {
    this.agenda = new Agenda();
  }

  public static AgendaBuilder builder() {
    return new AgendaBuilder();
  }

  public AgendaBuilder idAgenda(Integer idAgenda) {
    this.agenda.setIdAgenda(idAgenda);
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

  public AgendaBuilder idEstado(EstadosAgenda idEstado) {
    this.agenda.setIdEstado(idEstado);
    return this;
  }

  public AgendaBuilder idTipoServicio(TipoServicio idTipoServicio) {
    this.agenda.setIdTipoServicio(idTipoServicio);
    return this;
  }

  public AgendaBuilder idCliente(Cliente idCliente) {
    this.agenda.setIdCliente(idCliente);
    return this;
  }

  public AgendaBuilder idEmpleado(Empleado idEmpleado) {
    this.agenda.setIdEmpleado(idEmpleado);
    return this;
  }

  public AgendaBuilder idAdministrador(Administrador idAdministrador) {
    this.agenda.setIdAdministrador(idAdministrador);
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
