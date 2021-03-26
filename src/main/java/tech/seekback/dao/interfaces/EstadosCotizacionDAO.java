
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosCotizacion;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface EstadosCotizacionDAO extends DAO<EstadosCotizacion, Integer> {
  void delete(EstadosCotizacion estadosCotizacion) throws ConnectionExcep;
}
