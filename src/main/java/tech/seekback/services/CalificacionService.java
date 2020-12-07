/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.CalificacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Calificacion;

/**
 *
 * @author camorenoc
 */
@Stateless
public class CalificacionService {

  @EJB

  private CalificacionDAO calificacionDAO;

  public void create(Calificacion calificacion) throws ConnectionExcep {
    calificacionDAO.create(calificacion);
  }

  public Calificacion getOne(Integer id) throws ConnectionExcep {
    return calificacionDAO.getOne(id);
  }

  public List<Calificacion> getAll() throws ConnectionExcep {
    return calificacionDAO.getAll();
  }

  public void update(Calificacion calificacion) throws ConnectionExcep {
    calificacionDAO.update(calificacion);
  }

  public void delete(Integer id) throws ConnectionExcep {
    calificacionDAO.delete(id);
  }
}
