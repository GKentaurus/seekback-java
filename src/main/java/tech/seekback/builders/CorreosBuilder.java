
package tech.seekback.builders;

import tech.seekback.models.Correo;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class CorreosBuilder {

  private final Correo correos;

  private CorreosBuilder() {
    this.correos = new Correo();
  }

  public static CorreosBuilder builder() {
    return new CorreosBuilder();
  }

  public CorreosBuilder usuario(Usuario id) {
    this.correos.setUsuario(id);
    return this;
  }

  public CorreosBuilder correoElectronico(String correoElectronico) {
    this.correos.setCorreoElectronico(correoElectronico);
    return this;
  }

  public CorreosBuilder esPrincipal(Boolean esPrincipal) {
    this.correos.setEsPrincipal(esPrincipal);
    return this;
  }

  public CorreosBuilder timestamps(Timestamps timestamps) {
    this.correos.setTimestamps(timestamps);
    return this;
  }

  public Correo build() {
    return this.correos;
  }
}
