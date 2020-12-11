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

  public Empleado create(Empleado empleado) throws ConnectionExcep {
    return empleadoDAO.create(empleado);
  }

  public Empleado getOne(Integer id) throws ConnectionExcep {
    return empleadoDAO.getOne(id);
  }

  public List<Empleado> getAll() throws ConnectionExcep {
    return empleadoDAO.getAll();
  }

  public void update(Empleado empleado) throws ConnectionExcep {
    empleadoDAO.update(empleado);
  }

  public void delete(Integer id) throws ConnectionExcep {
    empleadoDAO.delete(id);
  }
}
