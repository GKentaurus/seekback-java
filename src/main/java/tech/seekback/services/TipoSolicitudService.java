/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.services;

import java.util.List;
import javax.ejb.*;
import tech.seekback.dao.interfaces.TipoSolicitudDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoSolicitud;

/**
 *
 * @author camorenoc
 */
@Stateless
public class TipoSolicitudService {

  @EJB
  private TipoSolicitudDAO tipoSolicitudDAO;

  public void create(TipoSolicitud tipoSolicitud) throws ConnectionExcep {
    tipoSolicitudDAO.create(tipoSolicitud);
  }

  public TipoSolicitud getOne(Integer id) throws ConnectionExcep {
    return tipoSolicitudDAO.getOne(id);
  }

  public List<TipoSolicitud> getAll() throws ConnectionExcep {
    List<TipoSolicitud> tipoSolicitudes = tipoSolicitudDAO.getAll();
    return tipoSolicitudes;
  }

  public void update(TipoSolicitud tipoSolicitud) throws ConnectionExcep {
    tipoSolicitudDAO.update(tipoSolicitud);
  }

  public void delete(Integer id) throws ConnectionExcep {
    tipoSolicitudDAO.delete(id);
  }
}
