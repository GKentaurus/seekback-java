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

  /**
   *
   * @param tipoSolicitud
   * @return Un objeto de tipo TipoSolicitud
   * @throws ConnectionExcep
   */
  public TipoSolicitud create(TipoSolicitud tipoSolicitud) throws ConnectionExcep {
    return tipoSolicitudDAO.create(tipoSolicitud);
  }

  /**
   *
   * @param id
   * @return Un objeto de tipo TipoSolicitud consultado por id
   * @throws ConnectionExcep
   */
  public TipoSolicitud getOne(Integer id) throws ConnectionExcep {
    return tipoSolicitudDAO.getOne(id);
  }

  /**
   *
   * @return Una colección de objetos de tipo TipoSolicitud (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<TipoSolicitud> getAll() throws ConnectionExcep {
    List<TipoSolicitud> tipoSolicitudes = tipoSolicitudDAO.getAll();
    return tipoSolicitudes;
  }

  /**
   * Actualiza un objeto de tipo TipoSolicitud
   *
   * @param tipoSolicitud
   * @throws ConnectionExcep
   */
  public void update(TipoSolicitud tipoSolicitud) throws ConnectionExcep {
    tipoSolicitudDAO.update(tipoSolicitud);
  }

  /**
   * Elimina un objeto de tipo TipoSolicitud
   *
   * @param id
   * @throws ConnectionExcep
   */
  public void delete(Integer id) throws ConnectionExcep {
    tipoSolicitudDAO.delete(id);
  }
}
