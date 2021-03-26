
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoSolicitud;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface TipoSolicitudDAO extends DAO<TipoSolicitud, Integer> {
  void delete(TipoSolicitud tipoSolicitud) throws ConnectionExcep;
}
