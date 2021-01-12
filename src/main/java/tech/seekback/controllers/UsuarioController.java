/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.*;
import tech.seekback.services.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author camorenoc
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

  @Inject
  private LoginController loginController;

  @EJB
  private UsuarioService usuarioService;

  @EJB
  private AdministradorService administradorService;

  @EJB
  private EmpleadoService empleadoService;

  @EJB
  private ClienteService clienteService;

  @EJB
  private DireccionService direccionService;

  @EJB
  private TelefonoService telefonoService;

  @EJB
  private CorreoService correoService;

  @EJB
  private TipoDocService tipoDocService;

  private Usuario usuario;
  private Correo correo;
  private Direccion direccion;
  private Telefono telefono;
  private List<Usuario> usuarios;
  private List<TipoDoc> tipoDocs;
  private Integer idTipoDoc;
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

  public Integer getIdTipoDoc() {
    return idTipoDoc;
  }

  public void setIdTipoDoc(Integer idTipoDoc) {
    this.idTipoDoc = idTipoDoc;
  }

  public List<Usuario> getUsuarios() throws ConnectionExcep {
    try {
      if (Objects.isNull(usuarios)) {
        usuarios = usuarioService.getAll();
      }
    } catch (ConnectionExcep ex) {
      System.out.println("Error al consultar los usuarios.....");
      ex.printStackTrace();
    }
    return usuarios;
  }

  public List<TipoDoc> getTipoDocs() {
    try {
      if (Objects.isNull(tipoDocs)) {
        tipoDocs = tipoDocService.getAll();
      }
    } catch (ConnectionExcep ex) {
      System.out.println("Error al consultar los usuarios.....");
      ex.printStackTrace();
    }
    return tipoDocs;
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

  public void updatePassword() throws ConnectionExcep {
    if (usuario.verificarContrasena(oldPassword)) {
      if (newPassword.equals(confirmPassword) && !oldPassword.equals(newPassword)) {
        usuario.setContrasena(newPassword);
        usuarioService.update(usuario);
      }
    }
  }

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
      switch (usuario.getRol().getId()) {
        case 1:
          administradorService.delete(administradorService.getByIdUsuario(usuario.getId()));
          break;
        case 2:
          empleadoService.delete(empleadoService.getByIdUsuario(usuario.getId()));
          break;
        case 3:
          clienteService.delete(clienteService.getByIdUsuario(usuario.getId()));
          break;
        default:
          System.out.println("Opción de ROL inválido");
          break;
      }

      usuarioService.delete(loginController.getUsuario());
      loginController.logout();
    } catch (ConnectionExcep ex) {
      System.out.println("Error al registrar usuario");
      ex.printStackTrace();
    }
  }

}