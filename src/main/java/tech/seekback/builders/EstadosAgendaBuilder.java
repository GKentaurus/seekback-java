
package tech.seekback.builders;

import tech.seekback.models.EstadosAgenda;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class EstadosAgendaBuilder {

  private final EstadosAgenda estadosAgenda;

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
