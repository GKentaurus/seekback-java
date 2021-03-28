
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TipoServicioDAO;
import tech.seekback.models.TipoServicio;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class TipoServicioDAOJPA extends GenericDAO<TipoServicio, Integer> implements TipoServicioDAO {

  public TipoServicioDAOJPA() {
    super(TipoServicio.class);
  }
}
