
package tech.seekback.services;

import tech.seekback.dao.interfaces.PaisDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Pais;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author danny
 */
@Stateless
public class PaisService {

  @EJB
  private PaisDAO paisDAO;

  /**
   * @param pais
   * @return Un objeto de tipo de tipo Pais
   * @throws ConnectionExcep
   */
  public Pais create(Pais pais) throws ConnectionExcep {
    return paisDAO.create(pais);
  }

  /**
   * @param id
   * @return Un objeto de tipo de tipo Pais consultado por el id
   * @throws ConnectionExcep
   */
  public Pais getOne(Integer id) throws ConnectionExcep {
    return paisDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Pais (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<Pais> getAll() throws ConnectionExcep {
    List<Pais> tipoDoc = paisDAO.getAll();
    return tipoDoc;
  }

  /**
   * Actualiza un objeto de tipo Pais
   *
   * @param pais
   * @throws ConnectionExcep
   */
  public void update(Pais pais) throws ConnectionExcep {
    paisDAO.update(pais);
  }

  /**
   * Elimina un objeto de tipo Pais
   *
   * @param pais
   * @throws ConnectionExcep
   */
  public void delete(Pais pais) throws ConnectionExcep {
    paisDAO.delete(pais);
  }
}
