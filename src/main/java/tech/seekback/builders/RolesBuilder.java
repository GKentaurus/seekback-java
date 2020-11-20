/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Roles;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class RolesBuilder {

  private Roles roles;

  private RolesBuilder() {
    this.roles = new Roles();
  }

  public static RolesBuilder builder() {
    return new RolesBuilder();
  }

  public RolesBuilder idRol(Integer idRol) {
    this.roles.setIdRol(idRol);
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

  public Roles build() {
    return this.roles;
  }
}
