
package tech.seekback.dao.jpa;

import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.BodegaDAO;
import tech.seekback.models.Bodega;

import javax.ejb.Stateless;

/**
 * @author gkentaurus
 */
@Stateless
public class BodegaDAOJPA extends GenericDAO<Bodega, Integer> implements BodegaDAO {

  public BodegaDAOJPA() {
    super(Bodega.class);
  }
}
