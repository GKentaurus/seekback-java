
package tech.seekback.builders;

import tech.seekback.models.EstadosFidelizacion;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class EstadosFidelizacionBuilder {

  private final EstadosFidelizacion estadosFidelizacion;

  private EstadosFidelizacionBuilder() {
    this.estadosFidelizacion = new EstadosFidelizacion();
  }

  public static EstadosFidelizacionBuilder builder() {
    return new EstadosFidelizacionBuilder();
  }

  public EstadosFidelizacionBuilder id(Integer id) {
    this.estadosFidelizacion.setId(id);
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
