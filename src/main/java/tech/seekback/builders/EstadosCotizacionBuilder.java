/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.EstadosCotizacion;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class EstadosCotizacionBuilder {

  private EstadosCotizacion estadosCotizacion;

  private EstadosCotizacionBuilder() {
    this.estadosCotizacion = new EstadosCotizacion();
  }

  public static EstadosCotizacionBuilder builder() {
    return new EstadosCotizacionBuilder();
  }

  public EstadosCotizacionBuilder id(Integer id) {
    this.estadosCotizacion.setId(id);
    return this;
  }

  public EstadosCotizacionBuilder nombreEstado(String nombreEstado) {
    this.estadosCotizacion.setNombreEstado(nombreEstado);
    return this;
  }

  public EstadosCotizacionBuilder timestamps(Timestamps timestamps) {
    this.estadosCotizacion.setTimestamps(timestamps);
    return this;
  }

  public EstadosCotizacion build() {
    return this.estadosCotizacion;
  }
}
