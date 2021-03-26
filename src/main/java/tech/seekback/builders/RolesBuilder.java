
package tech.seekback.builders;

import tech.seekback.models.Rol;
import tech.seekback.models.templates.Timestamps;

/**
 * @author gkentaurus
 */
public class RolesBuilder {

  private final Rol roles;

  private RolesBuilder() {
    this.roles = new Rol();
  }

  public static RolesBuilder builder() {
    return new RolesBuilder();
  }

  public RolesBuilder id(Integer id) {
    this.roles.setId(id);
    return this;
  }

  public RolesBuilder nombreRol(String nombreRol) {
    this.roles.setNombreRol(nombreRol);
    return this;
  }

  public RolesBuilder timestamps(Timestamps timestamps) {
    this.roles.setTimestamps(timestamps);
    return this;
  }

  public Rol build() {
    return this.roles;
  }
}
