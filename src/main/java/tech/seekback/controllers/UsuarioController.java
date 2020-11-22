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
import javax.inject.Named;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Roles;
import tech.seekback.models.TipoDoc;
import tech.seekback.models.Usuario;
import tech.seekback.services.UsuarioService;

/**
 *
 * @author camorenoc
 */
@ViewScoped
@Named
public class UsuarioController implements Serializable {

  @EJB
  private UsuarioService usuarioService;
  private Usuario usuario;
  private List<Usuario> usuarios;

  public UsuarioController() {
    usuario = new Usuario();
    usuario.setTipoDoc(new TipoDoc());
    usuario.setRol(new Roles());
  }

  @PostConstruct
  public void init() {

  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
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

  public void create() throws ConnectionExcep {
    try {
      usuarioService.create(usuario);
    } catch (ConnectionExcep ex) {
      System.out.println("Error al registrar usuario");
      ex.printStackTrace();
    }

  }
}
