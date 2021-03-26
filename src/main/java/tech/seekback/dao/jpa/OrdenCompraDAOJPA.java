
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.OrdenCompraDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.OrdenCompra;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import java.util.Date;

/**
 * @author gkentaurus
 */
@Stateless
public class OrdenCompraDAOJPA extends GenericDAO<OrdenCompra, Integer> implements OrdenCompraDAO {

  public OrdenCompraDAOJPA() {
    super(OrdenCompra.class);
  }

  /**
   * Elimina un objeto de tipo OrdenCompra
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(OrdenCompra obj) throws ConnectionExcep {
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
