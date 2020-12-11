/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.UsuarioDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

/**
 *
 * @author camorenoc
 */
@Stateless
public class UsuarioService {

  @EJB
  private UsuarioDAO usuarioDAO;

  public Usuario create(Usuario usuario) throws ConnectionExcep {
    return usuarioDAO.create(usuario);
  }

  public Usuario getOne(Integer id) throws ConnectionExcep {
    return usuarioDAO.getOne(id);
  }

  public List<Usuario> getAll() throws ConnectionExcep {
    List<Usuario> usuarios = usuarioDAO.getAll();
    return usuarios;
  }

  public void update(Usuario usuario) throws ConnectionExcep {
    usuarioDAO.update(usuario);
  }

  public void delete(Integer id) throws ConnectionExcep {
    usuarioDAO.delete(id);
  }
}
