
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.CategoriasProducto;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface CategoriasProductoDAO extends DAO<CategoriasProducto, Integer> {
  void delete(CategoriasProducto categoriasProducto) throws ConnectionExcep;
}
