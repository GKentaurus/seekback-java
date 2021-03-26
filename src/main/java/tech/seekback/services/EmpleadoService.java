
package tech.seekback.services;

import tech.seekback.dao.interfaces.EmpleadoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Empleado;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class EmpleadoService {

  @EJB

  private EmpleadoDAO empleadoDAO;

  /**
   * @param empleado
   * @return Un objeto de tipo Empleado
   * @throws ConnectionExcep
   */
  public Empleado create(Empleado empleado) throws ConnectionExcep {
    return empleadoDAO.create(empleado);
  }

  /**
   * @param id
   * @return Un objeto de tipo Empleado consultado por id
   * @throws ConnectionExcep
   */
  public Empleado getOne(Integer id) throws ConnectionExcep {
    return empleadoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Empleado (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Empleado> getAll() throws ConnectionExcep {
    return empleadoDAO.getAll();
  }

  /**
   * @param id del Usuario
   * @return Un objeto de tipo Cliente
   * @throws ConnectionExcep
   */
  public Empleado getByIdUsuario(Integer id) throws ConnectionExcep {
    return empleadoDAO.getByIdUsuario(id);
  }

  /**
   * Actualiza un objeto de tipo Empleado
   *
   * @param empleado
   * @throws ConnectionExcep
   */
  public void update(Empleado empleado) throws ConnectionExcep {
    empleadoDAO.update(empleado);
  }

  /**
   * Elimina un objeto de tipo Empleado
   *
   * @param empleado
   * @throws ConnectionExcep
   */
  public void delete(Empleado empleado) throws ConnectionExcep {
    empleadoDAO.delete(empleado);
  }
}
