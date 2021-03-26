
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.TipoDocDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoDoc;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import java.util.Date;

/**
 * @author gkentaurus
 */
@Stateless
public class TipoDocDAOJPA extends GenericDAO<TipoDoc, Integer> implements TipoDocDAO {

  public TipoDocDAOJPA() {
    super(TipoDoc.class);
  }

  /**
   * Elimina un objeto de tipo TipoDoc
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(TipoDoc obj) throws ConnectionExcep {
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
