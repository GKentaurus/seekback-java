
package tech.seekback.services;

import tech.seekback.dao.interfaces.FelicitacionDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Felicitacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class FelicitacionService {

  @EJB

  private FelicitacionDAO felicitacionDAO;

  /**
   * @param felicitacion
   * @return Un objeto de tipo Felicitación
   * @throws ConnectionExcep
   */
  public Felicitacion create(Felicitacion felicitacion) throws ConnectionExcep {
    return felicitacionDAO.create(felicitacion);
  }

  /**
   * @param id
   * @return Un objeto de tipo Felicitación consultado por el id
   * @throws ConnectionExcep
   */
  public Felicitacion getOne(Integer id) throws ConnectionExcep {
    return felicitacionDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo Felicitacion (referente al Dao que
   * lo implementa)
   * @throws ConnectionExcep
   */
  public List<Felicitacion> getAll() throws ConnectionExcep {
    return felicitacionDAO.getAll();
  }

  /**
   * @return Un entero de la consulta a felicitacion (referente al Dao que lo
   * implementa)
   * @throws ConnectionExcep
   */
  public Integer getAllCount() throws ConnectionExcep {
    Integer countfeli = felicitacionDAO.getAllCount();
    return countfeli;
  }

  /**
   * Actualiza un objeto de tipo Felicitacion
   *
   * @param felicitacion
   * @throws ConnectionExcep
   */
  public void update(Felicitacion felicitacion) throws ConnectionExcep {
    felicitacionDAO.update(felicitacion);
  }

  /**
   * Elimina un objeto de tipo Felicitacion
   *
   * @param felicitacion
   * @throws ConnectionExcep
   */
  public void delete(Felicitacion felicitacion) throws ConnectionExcep {
    felicitacionDAO.delete(felicitacion);
  }
}
