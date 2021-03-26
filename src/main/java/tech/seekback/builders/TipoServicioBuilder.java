
package tech.seekback.builders;

import tech.seekback.models.TipoServicio;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class TipoServicioBuilder {

  private final TipoServicio tipoServicio;

  private TipoServicioBuilder() {
    this.tipoServicio = new TipoServicio();
  }

  public static TipoServicioBuilder builder() {
    return new TipoServicioBuilder();
  }

  public TipoServicioBuilder idTipoServicio(Integer idTipoServicio) {
    this.tipoServicio.setId(idTipoServicio);
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
