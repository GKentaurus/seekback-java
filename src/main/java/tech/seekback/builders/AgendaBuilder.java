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
