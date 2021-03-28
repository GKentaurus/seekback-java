
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Direccion;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface DireccionDAO extends DAO<Direccion, Integer> {
  Direccion getByIdPrincipal(Integer idUsuario) throws ConnectionExcep;
}
