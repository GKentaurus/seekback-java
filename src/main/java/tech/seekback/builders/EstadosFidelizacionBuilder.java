/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.EstadosFidelizacion;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class EstadosFidelizacionBuilder {

  private EstadosFidelizacion estadosFidelizacion;

  private EstadosFidelizacionBuilder() {
    this.estadosFidelizacion = new EstadosFidelizacion();
  }

  public static EstadosFidelizacionBuilder builder() {
    return new EstadosFidelizacionBuilder();
  }

  public EstadosFidelizacionBuilder idEstado(Integer idEstado) {
    this.estadosFidelizacion.setIdEstado(idEstado);
    return this;
  }

  public EstadosFidelizacionBuilder nombreEstado(String nombreEstado) {
    this.estadosFidelizacion.setNombreEstado(nombreEstado);
    return this;
  }

  public EstadosFidelizacionBuilder timestamps(Timestamps timestamps) {
    this.estadosFidelizacion.setTimestamps(timestamps);
    return this;
  }

  public EstadosFidelizacion build() {
    return this.estadosFidelizacion;
  }
}
