
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProveedorDAO;
import tech.seekback.models.Proveedor;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class ProveedorDAOJPA extends GenericDAO<Proveedor, Integer> implements ProveedorDAO {

  public ProveedorDAOJPA() {
    super(Proveedor.class);
  }
}
