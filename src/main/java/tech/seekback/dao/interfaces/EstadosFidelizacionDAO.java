
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.EstadosFidelizacion;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface EstadosFidelizacionDAO extends DAO<EstadosFidelizacion, Integer> {
  void delete(EstadosFidelizacion estadosFidelizacion) throws ConnectionExcep;
}
