/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Rol;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class RolesBuilder {

  private Rol roles;

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
