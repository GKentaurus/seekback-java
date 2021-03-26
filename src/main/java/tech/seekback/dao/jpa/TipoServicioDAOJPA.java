
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TipoServicioDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoServicio;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import java.util.Date;

/**
 * @author gkentaurus
 */
@Stateless
public class TipoServicioDAOJPA extends GenericDAO<TipoServicio, Integer> implements TipoServicioDAO {

  public TipoServicioDAOJPA() {
    super(TipoServicio.class);
  }

  /**
   * Elimina un objeto de tipo TipoServicio
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(TipoServicio obj) throws ConnectionExcep {
    System.out.println(
      "\n\n\n\n\n######################################################################"
        + "\n#\t Eliminando el objeto No. " + this.classType.getSimpleName()
        + "\n######################################################################\n"
    );
    Timestamps tt = obj.getTimestamps();
    tt.setDeleted(true);
    tt.setDeleted_at(new Date());
    obj.setTimestamps(tt);
    create(obj);
  }
}
