/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;
import tech.seekback.models.Direccion;
import tech.seekback.models.Telefono;
import tech.seekback.models.Usuario;
import tech.seekback.services.CorreoService;
import tech.seekback.services.DireccionService;
import tech.seekback.services.TelefonoService;
import tech.seekback.services.UsuarioService;

/**
 *
 * @author danny
 */
@Named
@ViewScoped
public class PerfilController extends CustomController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private CorreoService correoService;

  @EJB
  private DireccionService direccionService;

  @EJB
  private TelefonoService telefonoService;

  private Usuario usuario;
  private Correo correo;
  private Direccion direccion;
  private Telefono telefono;
  private String oldPassword;
  private String newPassword;
  private String confirmPassword;

  @PostConstruct
  public void init() {
    this.usuario = loginController.getUsuario();
  }

  //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Correo getCorreo() throws ConnectionExcep {
    return correoService.getByIdPrincipal(usuario.getId());
  }

  public void setCorreo(Correo correo) {
    this.correo = correo;
  }

  public Direccion getDireccion() throws ConnectionExcep {
    Direccion temp = direccionService.getByIdPrincipal(usuario.getId());
    return temp;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public Telefono getTelefono() throws ConnectionExcep {
    return telefonoService.getByIdPrincipal(usuario.getId());
  }

  public void setTelefono(Telefono telefono) {
    this.telefono = telefono;
  }

  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  //</editor-fold>
  public void update() throws ConnectionExcep {
    try {
      usuarioService.update(usuario);
    } catch (ConnectionExcep ex) {
      System.out.println("Error al registrar usuario");
      ex.printStackTrace();
    }
  }

  public void delete() throws ConnectionExcep, IOException {
    try {
      usuarioService.delete(loginController.getUsuario());
      loginController.logout();
    } catch (ConnectionExcep ex) {
      System.out.println("Error al registrar usuario");
      ex.printStackTrace();
    }
  }

  public void updatePassword() throws ConnectionExcep {
    if (usuario.verificarContrasena(oldPassword)) {
      if (newPassword.equals(confirmPassword) && !oldPassword.equals(newPassword)) {
        usuario.setContrasena(newPassword);
        usuarioService.update(usuario);
      }
    }
  }
}
