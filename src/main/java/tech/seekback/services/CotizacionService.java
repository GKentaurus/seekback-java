/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.CotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Cotizacion;

/**
 *
 * @author camorenoc
 */
@Stateless
public class CotizacionService {

  @EJB

  private CotizacionDAO cotizacionDAO;

  public void create(Cotizacion cotizacion) throws ConnectionExcep {
    cotizacionDAO.create(cotizacion);
  }

  public Cotizacion getOne(Integer id) throws ConnectionExcep {
    return cotizacionDAO.getOne(id);
  }

  public List<Cotizacion> getAll() throws ConnectionExcep {
    return cotizacionDAO.getAll();
  }

  public void update(Cotizacion cotizacion) throws ConnectionExcep {
    cotizacionDAO.update(cotizacion);
  }

  public void delete(Integer id) throws ConnectionExcep {
    cotizacionDAO.delete(id);
  }
}
