/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Correo;
import tech.seekback.models.Direccion;
import tech.seekback.models.Rol;
import tech.seekback.models.Telefono;
import tech.seekback.models.TipoDoc;
import tech.seekback.models.Usuario;
import tech.seekback.services.CorreoService;
import tech.seekback.services.DireccionService;
import tech.seekback.services.TelefonoService;
import tech.seekback.services.TipoDocService;
import tech.seekback.services.UsuarioService;

/**
 *
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

  public UsuarioController() throws ConnectionExcep {
    this.usuario = new Usuario();
    this.telefono = new Telefono();
    this.correo = new Correo();
    this.direccion = new Direccion();
    this.usuario = loginController.getUsuario();
    this.telefono = telefonoService.getByIdPrincipal(usuario.getId());
    this.correo = correoService.getByIdPrincipal(usuario.getId());
    this.direccion = direccionService.getByIdPrincipal(usuario.getId());
  }
//
//  @PostConstruct
//  public void init() {
//  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Correo getCorreo() {
    return correo;
  }

  public void setCorreo(Correo correo) {
    this.correo = correo;
  }

  public Direccion getDireccion() {
    return direccion;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public Telefono getTelefono() {
    return telefono;
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

  public void create() throws ConnectionExcep {
    try {
      usuarioService.create(usuario);
    } catch (ConnectionExcep ex) {
      System.out.println("Error al registrar usuario");
      ex.printStackTrace();
    }

  }

}
