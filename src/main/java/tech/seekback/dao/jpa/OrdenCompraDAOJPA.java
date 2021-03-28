
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.OrdenCompraDAO;
import tech.seekback.models.OrdenCompra;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class OrdenCompraDAOJPA extends GenericDAO<OrdenCompra, Integer> implements OrdenCompraDAO {

  public OrdenCompraDAOJPA() {
    super(OrdenCompra.class);
  }
}
