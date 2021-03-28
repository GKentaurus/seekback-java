
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.CategoriasProductoDAO;
import tech.seekback.models.CategoriasProducto;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class CategoriasProductoDAOJPA extends GenericDAO<CategoriasProducto, Integer> implements CategoriasProductoDAO {

  public CategoriasProductoDAOJPA() {
    super(CategoriasProducto.class);
  }
}
