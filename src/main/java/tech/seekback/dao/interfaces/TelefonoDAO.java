
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Telefono;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface TelefonoDAO extends DAO<Telefono, Integer> {
  Telefono getByIdUsuario(Integer IdUsuario) throws ConnectionExcep;
  Telefono getByIdPrincipal(Integer IdUsuario) throws ConnectionExcep;
}
