/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.EstadosAgenda;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class EstadosAgendaBuilder {

  private EstadosAgenda estadosAgenda;

  private EstadosAgendaBuilder() {
    this.estadosAgenda = new EstadosAgenda();
  }

  public static EstadosAgendaBuilder builder() {
    return new EstadosAgendaBuilder();
  }

  public EstadosAgendaBuilder id(Integer id) {
    this.estadosAgenda.setId(id);
    return this;
  }

  public EstadosAgendaBuilder nombreEstado(String nombreEstado) {
    this.estadosAgenda.setNombreEstado(nombreEstado);
    return this;
  }

  public EstadosAgendaBuilder timestamps(Timestamps timestamps) {
    this.estadosAgenda.setTimestamps(timestamps);
    return this;
  }

  public EstadosAgenda build() {
    return this.estadosAgenda;
  }
}
