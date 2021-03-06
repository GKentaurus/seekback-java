
package tech.seekback.services;

import tech.seekback.dao.interfaces.TipoSolicitudDAO;
import tech.seekback.enums.ConnectionExcepEnum;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoSolicitud;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class TipoSolicitudService {

  @EJB
  private TipoSolicitudDAO tipoSolicitudDAO;

  private final String column = "nombreSolicitud";

  /**
   * @param tipoSolicitud
   * @return Un objeto de tipo TipoSolicitud
   * @throws ConnectionExcep
   */
  public TipoSolicitud create(TipoSolicitud tipoSolicitud) throws ConnectionExcep {
    if (this.tipoSolicitudDAO.checkIfExist(tipoSolicitud, column, tipoSolicitud.getNombreSolicitud())) {
      throw new ConnectionExcep(ConnectionExcepEnum.ERROR_DUPLICADO);
    }
    return this.tipoSolicitudDAO.create(tipoSolicitud);
  }

  public List<TipoSolicitud> create(List<TipoSolicitud> listaTipoSolicituds) throws ConnectionExcep {
    List<TipoSolicitud> errors = new ArrayList<>();
    for (TipoSolicitud tipoSolicitud : listaTipoSolicituds) {
      if (!this.tipoSolicitudDAO.checkIfExist(tipoSolicitud, column, tipoSolicitud.getNombreSolicitud())) {
        this.tipoSolicitudDAO.create(tipoSolicitud);
      } else {
        errors.add(tipoSolicitud);
      }
    }
    return errors;
  }

  /**
   * @param id
   * @return Un objeto de tipo TipoSolicitud consultado por id
   * @throws ConnectionExcep
   */
  public TipoSolicitud getOne(Integer id) throws ConnectionExcep {
    return tipoSolicitudDAO.getOne(id);
  }

  /**
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
   * @param tipoSolicitud
   * @throws ConnectionExcep
   */
  public void delete(TipoSolicitud tipoSolicitud) throws ConnectionExcep {
    tipoSolicitudDAO.delete(tipoSolicitud);
  }
}
