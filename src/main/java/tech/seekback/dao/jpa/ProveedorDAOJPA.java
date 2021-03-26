
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProveedorDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Proveedor;
import tech.seekback.models.templates.Timestamps;

import javax.ejb.Stateless;
import java.util.Date;

/**
 * @author gkentaurus
 */
@Stateless
public class ProveedorDAOJPA extends GenericDAO<Proveedor, Integer> implements ProveedorDAO {

  public ProveedorDAOJPA() {
    super(Proveedor.class);
  }

  /**
   * Elimina un objeto de tipo Proveedor
   *
   * @param obj
   * @throws ConnectionExcep
   */
  public void delete(Proveedor obj) throws ConnectionExcep {
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
