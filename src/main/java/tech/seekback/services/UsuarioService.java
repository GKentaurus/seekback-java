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

  /**
   *
   * @param usuario
   * @return Un objeto de tipo Usuario
   * @throws ConnectionExcep
   */
  public Usuario create(Usuario usuario) throws ConnectionExcep {
    return usuarioDAO.create(usuario);
  }

  /**
   *
   * @param id
   * @return Un ojeto de tipo Usuario consultado por id
   * @throws ConnectionExcep
   */
  public Usuario getOne(Integer id) throws ConnectionExcep {
    return usuarioDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo Usuario (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Usuario> getAll() throws ConnectionExcep {
    List<Usuario> usuarios = usuarioDAO.getAll();
    return usuarios;
  }

  /**
   * Actualiza un objeto de tipo Usuario
   *
   * @param usuario
   * @throws ConnectionExcep
   */
  public void update(Usuario usuario) throws ConnectionExcep {
    usuarioDAO.update(usuario);
  }

  /**
   * Elimina un objeto de tipo Usuario
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    usuarioDAO.delete(id);
  }
}
