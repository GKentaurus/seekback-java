package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.UsuarioDAO;
import tech.seekback.models.Usuario;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;

/**
 * @author gkentaurus
 */
@Stateless
public class UsuarioDAOJPA extends GenericDAO<Usuario, Integer> implements UsuarioDAO {

  public UsuarioDAOJPA() {
    super(Usuario.class);
  }

}
