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
import tech.seekback.models.Usuario;
import tech.seekback.services.UsuarioService;

/**
 *
 * @author camorenoc
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

  @EJB
  private UsuarioService usuarioService;
  private Usuario usuario;
  private List<Usuario> usuarios;

  public UsuarioController() {

  }

  @PostConstruct
  public void init() {

  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  // ********************************************************
  public void create() throws ConnectionExcep {
    usuarioService.create(this.usuario);
  }

  public Usuario getOne(Integer id) throws ConnectionExcep {
    this.usuario = usuarioService.getOne(id);
    return usuario;
  }

  public List<Usuario> getAll() throws ConnectionExcep {
    try {
      if (Objects.isNull(usuarios)) {
        this.usuarios = usuarioService.getAll();
      }
    } catch (ConnectionExcep ex) {
      System.out.println("Error al consultar los usuarios.....");
      ex.printStackTrace();
    }
    return usuarios;
  }
}
