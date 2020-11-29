/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.UsuarioDAO;
import tech.seekback.models.Usuario;

/**
 *
 * @author camorenoc
 */
@Stateless
public class UsuarioDAOJPA extends GenericDAO<Usuario, Integer> implements UsuarioDAO {

  public UsuarioDAOJPA() {
    super(Usuario.class);
  }

}
