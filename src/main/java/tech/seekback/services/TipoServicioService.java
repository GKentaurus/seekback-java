
package tech.seekback.services;

import tech.seekback.dao.interfaces.TipoServicioDAO;
import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.TipoServicio;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author gkentaurus
 */
@Stateless
public class TipoServicioService {

  @EJB
  private TipoServicioDAO tipoServicioDAO;

  /**
   * @param tipoServicio
   * @return Un ojeto de tipo TipoServicio
   * @throws ConnectionExcep
   */
  public TipoServicio create(TipoServicio tipoServicio) throws ConnectionExcep {
    return tipoServicioDAO.create(tipoServicio);
  }

  /**
   * @param id
   * @return Un ojeto de tipo TipoServicio consultado por id
   * @throws ConnectionExcep
   */
  public TipoServicio getOne(Integer id) throws ConnectionExcep {
    return tipoServicioDAO.getOne(id);
  }

  /**
   * @return Una colección de objetos de tipo TipoServicio (referente al Dao que lo implementa)
   * @throws ConnectionExcep
   */
  public List<TipoServicio> getAll() throws ConnectionExcep {
    List<TipoServicio> tipoServicios = tipoServicioDAO.getAll();
    return tipoServicios;
  }

  /**
   * Actualiza un objeto de tipo TipoServicio
   *
   * @param tipoServicio
   * @throws ConnectionExcep
   */
  public void update(TipoServicio tipoServicio) throws ConnectionExcep {
    tipoServicioDAO.update(tipoServicio);
  }

  /**
   * Elimina un objeto de tipo TipoServicio
   *
   * @param tipoServicio
   * @throws ConnectionExcep
   */
  public void delete(TipoServicio tipoServicio) throws ConnectionExcep {
    tipoServicioDAO.delete(tipoServicio);
  }
}
