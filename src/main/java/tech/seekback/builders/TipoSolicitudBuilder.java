/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.TipoSolicitud;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class TipoSolicitudBuilder {

  private TipoSolicitud tipoSolicitud;

  private TipoSolicitudBuilder() {
    tipoSolicitud = new TipoSolicitud();
  }

  public static TipoSolicitudBuilder builder() {
    return new TipoSolicitudBuilder();
  }

  public TipoSolicitudBuilder idTipoSolicitud(Integer idTipoSolicitud) {
    tipoSolicitud.setIdTipoSolicitud(idTipoSolicitud);
    return this;
  }

  public TipoSolicitudBuilder nombreSolicitud(String nombreSolicitud) {
    tipoSolicitud.setNombreSolicitud(nombreSolicitud);
    return this;
  }

  public TipoSolicitudBuilder timestamps(Timestamps timestamps) {
    tipoSolicitud.setTimestamps(timestamps);
    return this;
  }

  public TipoSolicitud build() {
    return tipoSolicitud;
  }
}
