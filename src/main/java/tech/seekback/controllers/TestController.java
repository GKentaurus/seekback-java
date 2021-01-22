/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class TestController implements Serializable {

  @EJB
  private UsuarioService usuarioService;

  public void encrypt() throws ConnectionExcep {
    List<Usuario> users = null;
    users = usuarioService.getAll();

    for (Usuario user : users) {
      String pass = user.getContrasena();
      user.setContrasena(pass);
      usuarioService.update(user);
    }
  }
}
