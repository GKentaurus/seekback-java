
package tech.seekback.builders;

import tech.seekback.models.Administrador;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class AdministradorBuilder {

  private final Administrador administrador;

  private AdministradorBuilder() {
    this.administrador = new Administrador();
  }

  public static AdministradorBuilder builder() {
    return new AdministradorBuilder();
  }

  public AdministradorBuilder id(Integer id) {
    this.administrador.setId(id);
    return this;
  }

  public AdministradorBuilder usuario(Usuario usuario) {
    this.administrador.setUsuario(usuario);
    return this;
  }

  public AdministradorBuilder timestamps(Timestamps timestamps) {
    this.administrador.setTimestamps(timestamps);
    return this;
  }

  public Administrador build() {
    return this.administrador;
  }
}
