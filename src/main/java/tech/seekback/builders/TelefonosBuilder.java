/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Telefono;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class TelefonosBuilder {

  private Telefono telefonos;

  private TelefonosBuilder() {
    this.telefonos = new Telefono();
  }

  public static TelefonosBuilder builder() {
    return new TelefonosBuilder();
  }

  public TelefonosBuilder idTelefono(Integer idTelefono) {
    this.telefonos.setId(idTelefono);
    return this;
  }

  public TelefonosBuilder idUsuario(Usuario idUsuario) {
    this.telefonos.setUsuario(idUsuario);
    return this;
  }

  public TelefonosBuilder numeroTelefono(String numeroTelefono) {
    this.telefonos.setNumeroTelefono(numeroTelefono);
    return this;
  }

  public TelefonosBuilder esPrincipal(Boolean esPrincipal) {
    this.telefonos.setEsPrincipal(esPrincipal);
    return this;
  }

  public TelefonosBuilder timestamps(Timestamps timestamps) {
    this.telefonos.setTimestamps(timestamps);
    return this;
  }

  public Telefono build() {
    return this.telefonos;
  }

}
