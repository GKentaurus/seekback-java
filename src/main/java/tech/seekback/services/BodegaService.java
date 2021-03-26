
package tech.seekback.services;

import tech.seekback.dao.interfaces.BodegaDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Bodega;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class BodegaService {

  @EJB

  private BodegaDAO bodegaDAO;

  /**
   * @param bodega
   * @return Un objeto de tipo Bodega
   * @throws ConnectionExcep
   */
  public Bodega create(Bodega bodega) throws ConnectionExcep {
    return bodegaDAO.create(bodega);
  }

  /**
   * @param id
   * @return Un objeto de tipo Bodega consultado por el id
   * @throws ConnectionExcep
   */
  public Bodega getOne(Integer id) throws ConnectionExcep {
    return bodegaDAO.getOne(id);
  }

  /**
   * @return Una coleccion de objetos de tipo Bodega (referente al DAO que lo implemente)
   * @throws ConnectionExcep
   */
  public List<Bodega> getAll() throws ConnectionExcep {
    return bodegaDAO.getAll();
  }

  /**
   * Actualiza un objeto tipo Bodega
   *
   * @param bodega
   * @throws ConnectionExcep
   */
  public void update(Bodega bodega) throws ConnectionExcep {
    bodegaDAO.update(bodega);
  }

  /**
   * Elimina un objeto de tipo Bodega
   *
   * @param bodega
   * @throws ConnectionExcep
   */
  public void delete(Bodega bodega) throws ConnectionExcep {
    bodegaDAO.delete(bodega);
  }
}
