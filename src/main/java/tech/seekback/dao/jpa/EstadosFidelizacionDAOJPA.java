
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.EstadosFidelizacionDAO;
import tech.seekback.models.EstadosFidelizacion;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class EstadosFidelizacionDAOJPA extends GenericDAO<EstadosFidelizacion, Integer> implements EstadosFidelizacionDAO {

  public EstadosFidelizacionDAOJPA() {
    super(EstadosFidelizacion.class);
  }
}
