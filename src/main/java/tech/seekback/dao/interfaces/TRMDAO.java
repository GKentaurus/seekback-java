
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.models.TRM;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface TRMDAO extends DAO<TRM, Integer> {
  //
}
