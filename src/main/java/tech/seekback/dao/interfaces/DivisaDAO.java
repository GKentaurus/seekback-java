
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Divisa;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface DivisaDAO extends DAO<Divisa, Integer> {
  void delete(Divisa divisa) throws ConnectionExcep;
}
