
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.models.Proveedor;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface ProveedorDAO extends DAO<Proveedor, Integer> {
  //
}
