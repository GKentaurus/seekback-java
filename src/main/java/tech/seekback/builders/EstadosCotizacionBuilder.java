
package tech.seekback.builders;

import tech.seekback.models.EstadosCotizacion;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class EstadosCotizacionBuilder {

  private final EstadosCotizacion estadosCotizacion;

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
