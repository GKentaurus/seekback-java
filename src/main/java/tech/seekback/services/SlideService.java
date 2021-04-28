
package tech.seekback.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tech.seekback.dao.interfaces.SlideDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Slide;

/**
 * @author danny
 */
@Stateless
public class SlideService {

  @EJB
  private SlideDAO slideDAO;

  /**
   * @param slide
   * @return Un objeto de tipo de tipo Pais
   * @throws ConnectionExcep
   */
  public Slide create(Slide slide) throws ConnectionExcep {
    return slideDAO.create(slide);
  }

  /**
   * @param id
   * @return Un objeto de tipo de tipo Pais consultado por el id
   * @throws ConnectionExcep
   */
  public Slide getOne(Integer id) throws ConnectionExcep {
    return slideDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Pais (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Slide> getAll() throws ConnectionExcep {
    return slideDAO.getAll();
  }

  /**
   * Actualiza un objeto de tipo Pais
   *
   * @param slide
   * @throws ConnectionExcep
   */
  public void update(Slide slide) throws ConnectionExcep {
    slideDAO.update(slide);
  }

  /**
   * Elimina un objeto de tipo Pais
   *
   * @param slide
   * @throws ConnectionExcep
   */
  public void delete(Slide slide) throws ConnectionExcep {
    slideDAO.delete(slide);
  }
}
