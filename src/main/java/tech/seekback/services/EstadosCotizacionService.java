/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.EstadosCotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosCotizacion;

/**
 *
 * @author camorenoc
 */
@Stateless
public class EstadosCotizacionService {

  @EJB
  private EstadosCotizacionDAO estadosCotizacionDAO;

  public void create(EstadosCotizacion estadosCotizacion) throws ConnectionExcep {
    estadosCotizacionDAO.create(estadosCotizacion);
  }

  public EstadosCotizacion getOne(Integer id) throws ConnectionExcep {
    return estadosCotizacionDAO.getOne(id);
  }

  public List<EstadosCotizacion> getAll(Integer id) throws ConnectionExcep {
    return estadosCotizacionDAO.getAll();
  }

  public void update(EstadosCotizacion estadosCotizacion) throws ConnectionExcep {
    estadosCotizacionDAO.update(estadosCotizacion);
  }

  public void delete(Integer id) throws ConnectionExcep {
    estadosCotizacionDAO.delete(id);
  }
}
