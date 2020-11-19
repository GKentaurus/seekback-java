/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Administrador;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class AdministradorBuilder {

  private Administrador administrador;

  private AdministradorBuilder() {
    this.administrador = new Administrador();
  }

  public static AdministradorBuilder builder() {
    return new AdministradorBuilder();
  }

  public AdministradorBuilder idAdministrador(Integer idAdministrador) {
    this.administrador.setIdAdministrador(idAdministrador);
    return this;
  }

  public AdministradorBuilder idUsuario(Usuario idUsuario) {
    this.administrador.setUsuario(idUsuario);
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
