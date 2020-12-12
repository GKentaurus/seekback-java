/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tech.seekback.dao.interfaces.EmpleadoDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Empleado;

/**
 *
 * @author camorenoc
 */
@Stateless
public class EmpleadoService {

  @EJB

  private EmpleadoDAO empleadoDAO;

  /**
   *
   * @param empleado
   * @return Un objeto de tipo Empleado
   * @throws ConnectionExcep
   */
  public Empleado create(Empleado empleado) throws ConnectionExcep {
    return empleadoDAO.create(empleado);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo Empleado consultado por id
   * @throws ConnectionExcep
   */
  public Empleado getOne(Integer id) throws ConnectionExcep {
    return empleadoDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo Empleado (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Empleado> getAll() throws ConnectionExcep {
    return empleadoDAO.getAll();
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
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    empleadoDAO.delete(id);
  }
}
