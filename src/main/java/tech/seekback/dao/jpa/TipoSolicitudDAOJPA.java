
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TipoSolicitudDAO;
import tech.seekback.models.TipoSolicitud;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class TipoSolicitudDAOJPA extends GenericDAO<TipoSolicitud, Integer> implements TipoSolicitudDAO {

  public TipoSolicitudDAOJPA() {
    super(TipoSolicitud.class);
  }
}
