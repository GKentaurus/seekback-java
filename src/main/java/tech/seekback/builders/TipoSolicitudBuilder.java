
package tech.seekback.builders;

import tech.seekback.models.TipoSolicitud;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class TipoSolicitudBuilder {

  private final TipoSolicitud tipoSolicitud;

  private TipoSolicitudBuilder() {
    this.tipoSolicitud = new TipoSolicitud();
  }

  public static TipoSolicitudBuilder builder() {
    return new TipoSolicitudBuilder();
  }

  public TipoSolicitudBuilder idTipoSolicitud(Integer idTipoSolicitud) {
    tipoSolicitud.setId(idTipoSolicitud);
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
    return this.tipoSolicitud;
  }
}
