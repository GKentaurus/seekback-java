
package tech.seekback.builders;

import tech.seekback.models.Pais;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class PaisBuilder {

  private final Pais pais;

  private PaisBuilder() {
    this.pais = new Pais();
  }

  public static PaisBuilder builder() {
    return new PaisBuilder();
  }

  public PaisBuilder id(Integer id) {
    this.pais.setId(id);
    return this;
  }

  public PaisBuilder nombrePais(String nombrePais) {
    this.pais.setNombrePais(nombrePais);
    return this;
  }

  public PaisBuilder timestamps(Timestamps timestamps) {
    this.pais.setTimestamps(timestamps);
    return this;
  }

  public Pais build() {
    return this.pais;
  }
}
