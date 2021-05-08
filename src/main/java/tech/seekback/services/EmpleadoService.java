
package tech.seekback.services;

import tech.seekback.dao.interfaces.EmpleadoDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Usuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class EmpleadoService {

  @EJB
  private EmpleadoDAO empleadoDAO;

  private final String column = "numeroDoc";

  /**
   * @param empleado
   * @return Un objeto de tipo Empleado
   * @throws ConnectionExcep
   */
  public Usuario create(Usuario empleado) throws ConnectionExcep {
    if (this.empleadoDAO.checkIfExist(empleado, column, empleado.getNumeroDoc())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return this.empleadoDAO.create(empleado);
  }

  public List<Usuario> create(List<Usuario> listaClientes) throws ConnectionExcep {
    List<Usuario> errors = new ArrayList<>();
    for (Usuario empleado : listaClientes) {
      if (!this.empleadoDAO.checkIfExist(empleado, column, empleado.getNumeroDoc())) {
        this.empleadoDAO.create(empleado);
      } else {
        errors.add(empleado);
      }
    }
    return errors;
  }

  /**
   * @param id
   * @return Un objeto de tipo Empleado consultado por id
   * @throws ConnectionExcep
   */
  public Usuario getOne(Integer id) throws ConnectionExcep {
    return empleadoDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Empleado (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Usuario> getAll() throws ConnectionExcep {
    return empleadoDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo Empleado
   *
   * @param empleado
   * @throws ConnectionExcep
   */
  public void update(Usuario empleado) throws ConnectionExcep {
    empleadoDAO.update(empleado);
  }

  /**
   * Elimina un objeto de tipo Empleado
   *
   * @param empleado
   * @throws ConnectionExcep
   */
  public void delete(Usuario empleado) throws ConnectionExcep {
    empleadoDAO.delete(empleado);
  }
}
