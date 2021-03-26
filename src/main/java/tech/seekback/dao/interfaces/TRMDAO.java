
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TRM;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface TRMDAO extends DAO<TRM, Integer> {
  void delete(TRM trm) throws ConnectionExcep;
}
