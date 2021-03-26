
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Empleado;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface EmpleadoDAO extends DAO<Empleado, Integer> {
  Empleado getByIdUsuario(Integer id) throws ConnectionExcep;
  void delete(Empleado empleado) throws ConnectionExcep;
}
