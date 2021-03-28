
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.ProductoDAO;
import tech.seekback.models.Producto;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class ProductoDAOJPA extends GenericDAO<Producto, Integer> implements ProductoDAO {

  public ProductoDAOJPA() {
    super(Producto.class);
  }
}
