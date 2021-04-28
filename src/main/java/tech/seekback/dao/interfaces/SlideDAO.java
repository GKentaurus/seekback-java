
package tech.seekback.dao.interfaces;

import javax.ejb.Local;
import tech.seekback.dao.DAO;
import tech.seekback.models.Slide;

/**
 * @author gkentaurus
 */
@Local
public interface SlideDAO extends DAO<Slide, Integer> {
  //
}
