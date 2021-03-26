
package tech.seekback.services;

import tech.seekback.dao.interfaces.EstadosCotizacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosCotizacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class EstadosCotizacionService {

  @EJB
  private EstadosCotizacionDAO estadosCotizacionDAO;

  /**
   * @param estadosCotizacion
   * @return Un objeto de tipo EstadosCotizacion
   * @throws ConnectionExcep
   */
  public EstadosCotizacion create(EstadosCotizacion estadosCotizacion) throws ConnectionExcep {
    return estadosCotizacionDAO.create(estadosCotizacion);
  }

  /**
   * @param id
   * @return Un objeto de tipo EstadosCotizacion consultado por id
   * @throws ConnectionExcep
   */
  public EstadosCotizacion getOne(Integer id) throws ConnectionExcep {
    return estadosCotizacionDAO.getOne(id);
  }

  /**
   * @param id
   * @return Una colección de objetos de tipo EstadosCotizacion consultado por id (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<EstadosCotizacion> getAll(Integer id) throws ConnectionExcep {
    return estadosCotizacionDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo EstadosCotizacion
   *
   * @param estadosCotizacion
   * @throws ConnectionExcep
   */
  public void update(EstadosCotizacion estadosCotizacion) throws ConnectionExcep {
    estadosCotizacionDAO.update(estadosCotizacion);
  }

  /**
   * Elimina un objeto de tipo EstadosCotizacion
   *
   * @param estadosCotizacion
   * @throws ConnectionExcep
   */
  public void delete(EstadosCotizacion estadosCotizacion) throws ConnectionExcep {
    estadosCotizacionDAO.delete(estadosCotizacion);
  }
}
