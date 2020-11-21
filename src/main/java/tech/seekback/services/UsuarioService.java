/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import tech.seekback.dao.interfaces.UsuarioDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

/**
 *
 * @author camorenoc
 */
public class UsuarioService {

  @EJB
  private UsuarioDAO usuarioDAO;

  public void create(Usuario usuario) throws ConnectionExcep {
    usuarioDAO.create(usuario);
  }

  public List<Usuario> getAll() throws ConnectionExcep {
    List<Usuario> usuarios = usuarioDAO.getAll();
    return usuarios;
  }
}
