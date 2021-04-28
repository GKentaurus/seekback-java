
package tech.seekback.dao.jpa;

import javax.ejb.Stateless;
import tech.seekback.dao.GenericDAO;
import tech.seekback.dao.interfaces.SlideDAO;
import tech.seekback.models.Slide;

/**
 * @author gkentaurus
 */
@Stateless
public class SlideDAOJPA extends GenericDAO<Slide, Integer> implements SlideDAO {

  public SlideDAOJPA() {
    super(Slide.class);
  }
}
