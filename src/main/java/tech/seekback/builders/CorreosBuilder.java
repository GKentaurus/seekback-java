/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.builders;

import tech.seekback.models.Correos;
import tech.seekback.models.Usuario;
import tech.seekback.models.templates.Timestamps;

/**
 *
 * @author camorenoc
 */
public class CorreosBuilder {

  private Correos correos;

  private CorreosBuilder() {
    this.correos = new Correos();
  }

  public static CorreosBuilder builder() {
    return new CorreosBuilder();
  }

  public CorreosBuilder idUsuario(Usuario idUsuario) {
    this.correos.setIdUsuario(idUsuario);
    return this;
  }

  public CorreosBuilder correoElectronico(String correoElectronico) {
    this.correos.setCorreoElectronico(correoElectronico);
    return this;
  }

  public CorreosBuilder esPrincipal(boolean esPrincipal) {
    this.correos.setEsPrincipal(esPrincipal);
    return this;
  }
  
  public CorreosBuilder timestamps(Timestamps timestamps) {
    this.correos.setTimestamps(timestamps);
    return this;
  }

  public Correos build() {
    return this.correos;
  }
}
