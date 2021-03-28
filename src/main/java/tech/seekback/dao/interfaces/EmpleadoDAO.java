
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface EmpleadoDAO extends DAO<Usuario, Integer> {
  Usuario getByIdUsuario(Integer id) throws ConnectionExcep;
}
