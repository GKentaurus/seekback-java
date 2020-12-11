/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.EstadosFidelizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosFidelizacion;

/**
 *
 * @author camorenoc
 */
@Stateless
public class EstadosFidelizacionService {

  @EJB
  private EstadosFidelizacionDAO estadosFidelizacionDAO;

  public EstadosFidelizacion create(EstadosFidelizacion rol) throws ConnectionExcep {
    return estadosFidelizacionDAO.create(rol);
  }

  public EstadosFidelizacion getOne(Integer id) throws ConnectionExcep {
    return estadosFidelizacionDAO.getOne(id);
  }

  public List<EstadosFidelizacion> getAll() throws ConnectionExcep {
    List<EstadosFidelizacion> estadosFidelizaciones = estadosFidelizacionDAO.getAll();
    return estadosFidelizaciones;
  }

  public void update(EstadosFidelizacion estadosFidelizacion) throws ConnectionExcep {
    estadosFidelizacionDAO.update(estadosFidelizacion);
  }

  public void delete(Integer id) throws ConnectionExcep {
    estadosFidelizacionDAO.delete(id);
  }
}
