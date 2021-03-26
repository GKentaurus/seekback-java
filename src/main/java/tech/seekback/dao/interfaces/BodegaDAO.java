
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Bodega;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface BodegaDAO extends DAO<Bodega, Integer> {
  void delete(Bodega bodega) throws ConnectionExcep;
}
