/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Roles;
import tech.seekback.models.TipoDoc;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class UsuarioBuilder {

  private Usuario usuario;

  private UsuarioBuilder() {
    usuario = new Usuario();
  }

  public static UsuarioBuilder builder() {
    return new UsuarioBuilder();
  }

  public UsuarioBuilder idUsuario(Integer id) {
    this.usuario.setIdUsuario(id);
    System.out.println("\n sdasd");
    return this;
  }

  public UsuarioBuilder pNombre(String pNombre) {
    this.usuario.setpNombre(pNombre);
    return this;
  }

  public UsuarioBuilder sNombres(String sNombres) {
    this.usuario.setsNombres(sNombres);
    return this;
  }

  public UsuarioBuilder pApellido(String pApellido) {
    this.usuario.setpApellido(pApellido);
    return this;
  }

  public UsuarioBuilder sApellido(String sApellido) {
    this.usuario.setsApellido(sApellido);
    return this;
  }

  public UsuarioBuilder tipoDoc(TipoDoc tipoDoc) {
    this.usuario.setTipoDoc(tipoDoc);
    return this;
  }

  public UsuarioBuilder numeroDoc(String numeroDoc) {
    this.usuario.setNumeroDoc(numeroDoc);
    return this;
  }

  public UsuarioBuilder contrasena(String contrasena) {
    this.usuario.setContrasena(contrasena);
    return this;
  }

  public UsuarioBuilder rol(Roles rol) {
    this.usuario.setRol(rol);
    return this;
  }

  public UsuarioBuilder timestamps(Timestamps timestamps) {
    this.usuario.setTimestamps(timestamps);
    return this;
  }

  public Usuario build() {
    return usuario;
  }
}
