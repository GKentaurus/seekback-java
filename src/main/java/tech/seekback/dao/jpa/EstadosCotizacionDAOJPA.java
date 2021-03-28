
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EstadosCotizacionDAO;
import tech.seekback.models.EstadosCotizacion;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class EstadosCotizacionDAOJPA extends GenericDAO<EstadosCotizacion, Integer> implements EstadosCotizacionDAO {

  public EstadosCotizacionDAOJPA() {
    super(EstadosCotizacion.class);
  }
}
