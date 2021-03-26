
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Rol;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface RolDAO extends DAO<Rol, Integer> {
  void delete(Rol rol) throws ConnectionExcep;
}
