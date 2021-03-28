
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.models.Producto;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface ProductoDAO extends DAO<Producto, Integer> {
  //
}
