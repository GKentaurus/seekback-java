
package tech.seekback.dao.interfaces;

import tech.seekback.dao.DAO;
import tech.seekback.models.TipoDoc;

import javax.ejb.Local;

/**
 * @author gkentaurus
 */
@Local
public interface TipoDocDAO extends DAO<TipoDoc, Integer> {
  //
}
