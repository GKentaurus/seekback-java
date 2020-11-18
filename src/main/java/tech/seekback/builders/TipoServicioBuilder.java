/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.TipoServicio;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class TipoServicioBuilder {

  private TipoServicio tipoServicio;

  private TipoServicioBuilder() {
    this.tipoServicio = new TipoServicio();
  }

  public static TipoServicioBuilder builder() {
    return new TipoServicioBuilder();
  }

  public TipoServicioBuilder idTipoServicio(Integer idTipoServicio) {
    this.tipoServicio.setIdTipoServicio(idTipoServicio);
    return this;
  }

  public TipoServicioBuilder nombreServicio(String nombreServicio) {
    this.tipoServicio.setNombreServicio(nombreServicio);
    return this;
  }

  public TipoServicioBuilder timestamps(Timestamps timestamps) {
    this.tipoServicio.setTimestamps(timestamps);
    return this;
  }

  public TipoServicio build() {
    return this.tipoServicio;
  }
}
