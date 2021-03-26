
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Administrador;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface AdministradorDAO extends DAO<Administrador, Integer> {
  Administrador getByIdUsuario(Integer id) throws ConnectionExcep;
  void delete(Administrador administrador) throws ConnectionExcep;
}
