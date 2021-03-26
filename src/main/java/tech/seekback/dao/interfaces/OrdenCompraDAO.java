
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.OrdenCompra;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface OrdenCompraDAO extends DAO<OrdenCompra, Integer> {
  void delete(OrdenCompra ordenCompra) throws ConnectionExcep;
}
