/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tech.seekback.models.Correos;
import tech.seekback.models.Direcciones;
import tech.seekback.models.Telefonos;
import tech.seekback.models.TipoDoc;
import tech.seekback.models.Usuario;

/**
 *
 * @author danny
 */
@ViewScoped
@Named
public class RegistrerController implements Serializable {

  private Usuario usuario;
  private Correos correo;
  private Telefonos telefono;
  private Direcciones direcciones;

  public RegistrerController() {
    usuario = new Usuario();
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public void registrer() {
    System.out.println(usuario);
  }

}
